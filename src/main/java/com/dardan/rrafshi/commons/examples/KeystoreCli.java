package com.dardan.rrafshi.commons.examples;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dardan.rrafshi.commons.crypto.KeystoreException.KeyAlreadyExist;
import com.dardan.rrafshi.commons.crypto.KeystoreException.KeyNotFound;
import com.dardan.rrafshi.commons.crypto.KeystoreException.KeystoreNotFound;
import com.dardan.rrafshi.commons.crypto.KeystoreManager;


public final class KeystoreCli
{
	private static final Logger LOGGER = LogManager.getLogger(KeystoreCli.class);


	public static void main(final String[] args)
	{
		try(Scanner scanner = new Scanner(System.in)) {
			final KeystoreManager keystoreManager = new KeystoreManager();

			if(args.length < 1) {
				System.out.println("Wrong usage of Keystore CLI: Type in --help for more information");
			}
			else if(args[0].equals("--create")) {
				System.out.println("Enter the property key, which will asociated with your password:");
				final String key = scanner.next();

				System.out.println("Enter your password: ");
				final String password = scanner.next();

				keystoreManager.createPassword(key, password);
			}
			else if(args[0].equals("--read")) {
				System.out.println("Enter the property key of your password:");
				final String key = scanner.next();

				System.out.println("Password: " + keystoreManager.retrievePassword(key));
			}
			else if(args[0].equals("--update")) {
				System.out.println("Enter the property key of your password:");
				final String key = scanner.next();

				System.out.println("Enter your new password:");
				final String newPassword = scanner.next();

				keystoreManager.updatePassword(key, newPassword);
			}
			else if(args[0].equals("--delete")) {
				System.out.println("Enter the property key of your password:");
				final String key = scanner.next();

				keystoreManager.deletePassword(key);
			}
			else if(args[0].equals("--save")) {
				System.out.println("Enter the property key of your password:");
				final String key = scanner.next();

				System.out.println("Enter your password:");
				final String password = scanner.next();

				keystoreManager.savePassword(key, password);
			}
			else if(args[0].equals("--help")) {
				System.out.println("Usage of Keystore CLI: ");
				System.out.println("**************************************");
				System.out.println("--create - create a new password");
				System.out.println("--read - show a saved password");
				System.out.println("--update - update a password");
				System.out.println("--delete - delete a password");
				System.out.println("--save - saves a password");
				System.out.println("**************************************");
				System.out.println("");

			} else {
				System.out.println("Wrong usage of Keystore CLI: Type in --help for more information");
			}
		} catch(final KeystoreNotFound | KeyAlreadyExist | KeyNotFound exception) {

			LOGGER.error(exception.getMessage(), exception);
		}
	}
}
