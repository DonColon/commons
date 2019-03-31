package com.dardan.rrafshi.commons.security;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.dardan.rrafshi.commons.Constants;


public final class KeystoreManager
{
	private final Properties keystore;
	private final Path keystorePath;


	public KeystoreManager()
		throws IOException
	{
		this.keystore = new Properties();
		this.keystorePath = Paths.get(Constants.CRYPTO_PATH, Constants.CRYPTO_FILE);

		if(Files.notExists(this.keystorePath)) {
			Files.createDirectories(this.keystorePath.getParent());
			Files.createFile(this.keystorePath);
		} else {
			this.loadKeystore();
		}
	}


	public void loadKeystore()
		throws IOException
	{
		try(InputStream dataIn = new BufferedInputStream(new FileInputStream(this.keystorePath.toFile()))) {
			this.keystore.load(dataIn);
		}
	}

	public void saveKeystore()
		throws IOException
	{
		try(OutputStream dataOut = new BufferedOutputStream(new FileOutputStream(this.keystorePath.toFile()))) {
			this.keystore.store(dataOut, "");
		}
	}



}
