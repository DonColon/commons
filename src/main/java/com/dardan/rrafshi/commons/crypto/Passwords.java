package com.dardan.rrafshi.commons.crypto;

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

import com.dardan.rrafshi.commons.Constants;


public final class Passwords
{
	private static final Logger LOGGER = LogManager.getLogger(Passwords.class);

	private static final String AES_SALT = System.getenv("AES_SALT");
	private static final String AES_SECRET = System.getenv("AES_SECRET");


	private Passwords() {}


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
			LOGGER.error(exception.getMessage(), exception);
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

			return new String(cipher.doFinal(Base64.getDecoder().decode(passwordToDecrypt)), "UTF-8");

		} catch(final Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return null;
	}
}
