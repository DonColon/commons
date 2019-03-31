package com.dardan.rrafshi.commons.examples;

import com.dardan.rrafshi.commons.Passwords;

public final class TestEncription
{

	public static void main(final String[] args)
	{
		final String password = "password1234";

		final String encryptedPassword = Passwords.encrypt(password);
		final String decryptedPassword = Passwords.decrypt(encryptedPassword);

		System.out.println(password);
		System.out.println(encryptedPassword);
		System.out.println(decryptedPassword);
	}

}
