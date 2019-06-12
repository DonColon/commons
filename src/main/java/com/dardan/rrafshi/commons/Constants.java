package com.dardan.rrafshi.commons;

public final class Constants
{
	public static final String CRYPTO_DERIVATION_FUNCTION = "PBKDF2WithHmacSHA256";
	public static final String CRYPTO_TRANSFORMATION = "AES/CBC/PKCS5Padding";
	public static final String CRYPTO_ALGORITHM = "AES";
	public static final String CRYPTO_SECRET = "AES_SECRET";
	public static final String CRYPTO_SALT = "AES_SALT";

	public static final String CRYPTO_PATH = "C:\\security";
	public static final String CRYPTO_FILE = "keystore.properties";


	private Constants() {}
}
