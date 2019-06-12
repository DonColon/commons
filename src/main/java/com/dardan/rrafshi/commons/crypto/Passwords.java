package com.dardan.rrafshi.commons.crypto;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Charsets;
import com.dardan.rrafshi.commons.Constants;
import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.commons.crypto.KeystoreException.KeystoreNotFound;


public final class Passwords
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Passwords.class);


	private Passwords() {}


	public static String getPasswordFromFile(final String key)
	{
		try {
			final KeystoreManager keystoreManager = new KeystoreManager();

			return keystoreManager.retrievePassword(key);

		} catch (final KeystoreNotFound exception) {

			LOGGER.error(exception.getMessage(), exception);
		}

		return null;
	}

	public static String encrypt(final String passwordToEncrypt)
	{
		final String password = Systems.getEnvironmentVariable(Constants.CRYPTO_SECRET);
		final String salt = Systems.getEnvironmentVariable(Constants.CRYPTO_SALT);

		try {
			final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			final IvParameterSpec parameterSpecification = new IvParameterSpec(iv);

			final SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.CRYPTO_DERIVATION_FUNCTION);
			final KeySpec specification = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
			final SecretKey secret = factory.generateSecret(specification);
			final SecretKeySpec secretKeySpecification = new SecretKeySpec(secret.getEncoded(), Constants.CRYPTO_ALGORITHM);

			final Cipher cipher = Cipher.getInstance(Constants.CRYPTO_TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecification, parameterSpecification);

			return Base64.getEncoder().encodeToString(cipher.doFinal(passwordToEncrypt.getBytes(Charsets.UTF_8)));

		} catch(final Exception exception) {

			LOGGER.error(exception.getMessage(), exception);
		}

		return null;
	}

	public static String decrypt(final String passwordToDecrypt)
	{
		final String password = Systems.getEnvironmentVariable(Constants.CRYPTO_SECRET);
		final String salt = Systems.getEnvironmentVariable(Constants.CRYPTO_SALT);

		try {
			final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			final IvParameterSpec parameterSpecification = new IvParameterSpec(iv);

			final SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.CRYPTO_DERIVATION_FUNCTION);
			final KeySpec specification = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
			final SecretKey secret = factory.generateSecret(specification);
			final SecretKeySpec secretKeySpecification = new SecretKeySpec(secret.getEncoded(), Constants.CRYPTO_ALGORITHM);

			final Cipher cipher = Cipher.getInstance(Constants.CRYPTO_TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpecification, parameterSpecification);

			return new String(cipher.doFinal(Base64.getDecoder().decode(passwordToDecrypt)), Charsets.UTF_8);

		} catch(final Exception exception) {

			LOGGER.error(exception.getMessage(), exception);
		}

		return null;
	}
}
