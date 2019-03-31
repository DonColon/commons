package com.dardan.rrafshi.commons;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Passwords
{
	private static final Logger logger = LogManager.getLogger(Passwords.class);

	private static final String AES_SALT = System.getenv("AES_SALT");
	private static final String AES_SECRET = System.getenv("AES_SECRET");


	public static String encrypt(final String passwordToEncrypt)
	{
		try {
			final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			final IvParameterSpec parameterSpecification = new IvParameterSpec(iv);

			final SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.CRYPTO_ALGORITHM);
			final KeySpec specification = new PBEKeySpec(AES_SECRET.toCharArray(), AES_SALT.getBytes(), 65536, 256);
			final SecretKey secret = factory.generateSecret(specification);
			final SecretKeySpec secretKeySpecification = new SecretKeySpec(secret.getEncoded(), "AES");

			final Cipher cipher = Cipher.getInstance(Constants.CRYPTO_TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpecification, parameterSpecification);

			return Base64.getEncoder().encodeToString(cipher.doFinal(passwordToEncrypt.getBytes("UTF-8")));

		} catch(final Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return null;
	}

	public static String decrypt(final String passwordToDecrypt)
	{
		try {
			final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			final IvParameterSpec parameterSpecification = new IvParameterSpec(iv);

			final SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.CRYPTO_ALGORITHM);
			final KeySpec specification = new PBEKeySpec(AES_SECRET.toCharArray(), AES_SALT.getBytes(), 65536, 256);
			final SecretKey secret = factory.generateSecret(specification);
			final SecretKeySpec secretKeySpecification = new SecretKeySpec(secret.getEncoded(), "AES");

			final Cipher cipher = Cipher.getInstance(Constants.CRYPTO_TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpecification, parameterSpecification);

			return new String(cipher.doFinal(Base64.getDecoder().decode(passwordToDecrypt)));

		} catch(final Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return null;
	}


	public Passwords() {}
}
