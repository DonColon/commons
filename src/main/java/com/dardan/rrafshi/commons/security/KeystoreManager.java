package com.dardan.rrafshi.commons.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.dardan.rrafshi.commons.Constants;
import com.dardan.rrafshi.commons.security.KeystoreException.KeyAlreadyExist;
import com.dardan.rrafshi.commons.security.KeystoreException.KeyNotFound;


public final class KeystoreManager
{
	private final Properties keystore;
	private final Path keystorePath;


	public KeystoreManager(final String keystorePath, final String keystoreFilename)
		throws KeystoreException.KeystoreNotFound
	{
		try {
			this.keystore = new Properties();
			this.keystorePath = Paths.get(keystorePath, keystoreFilename);

			if(Files.notExists(this.keystorePath)) {
				Files.createDirectories(this.keystorePath.getParent());
				Files.createFile(this.keystorePath);
			} else {
				this.loadKeystore();
			}

		} catch (final IOException exception) {

			throw new KeystoreException.KeystoreNotFound("Failed to create keystore properties", exception);
		}
	}

	public KeystoreManager()
		throws KeystoreException.KeystoreNotFound
	{
		this(Constants.CRYPTO_PATH, Constants.CRYPTO_FILE);
	}


	public void loadKeystore()
		throws KeystoreException.KeystoreNotFound
	{
		try(InputStream dataIn = Files.newInputStream(this.keystorePath)) {
			this.keystore.load(dataIn);

		} catch (final IOException exception) {

			throw new KeystoreException.KeystoreNotFound("Failed to load keystore properties", exception);
		}
	}

	public void saveKeystore()
		throws KeystoreException.KeystoreNotFound
	{
		try(OutputStream dataOut = Files.newOutputStream(this.keystorePath)) {
			this.keystore.store(dataOut, "");

		} catch (final IOException exception) {

			throw new KeystoreException.KeystoreNotFound("Failed to save keystore properties", exception);
		}
	}


	public void createPassword(final String key, final String password)
		throws KeystoreException.KeyAlreadyExist, KeystoreException.KeystoreNotFound
	{
		if(this.keystore.containsKey(key))
			throw new KeystoreException.KeyAlreadyExist("The key '" + key + "' already exist");

		final String encryptedPassword = Passwords.encrypt(password);
		this.keystore.setProperty(key, encryptedPassword);
		this.saveKeystore();
	}

	public String retrievePassword(final String key)
	{
		final String password = this.keystore.getProperty(key);
		final String decryptedPassword = Passwords.decrypt(password);
		return decryptedPassword;
	}

	public void updatePassword(final String key, final String password)
		throws KeystoreException.KeyNotFound, KeystoreException.KeystoreNotFound
	{
		if(!this.keystore.containsKey(key))
			throw new KeystoreException.KeyNotFound("The key '" + key + "' doesn't exist");

		final String encryptedPassword = Passwords.encrypt(password);
		this.keystore.setProperty(key, encryptedPassword);
		this.saveKeystore();
	}

	public void deletePassword(final String key)
		throws KeystoreException.KeyNotFound, KeystoreException.KeystoreNotFound
	{
		if(!this.keystore.containsKey(key))
			throw new KeystoreException.KeyNotFound("The key '" + key + "' doesn't exist");

		this.keystore.remove(key);
		this.saveKeystore();
	}

	public void savePassword(final String key, final String password)
		throws KeystoreException.KeystoreNotFound
	{
		try {
			if(this.keystore.containsKey(key))
				this.updatePassword(key, password);
			else
				this.createPassword(key, password);

		} catch (KeyNotFound | KeyAlreadyExist exception) {

			// This can't happen since this method checks if the key exists or not
			// and calls the right method for each case.
		}
	}
}
