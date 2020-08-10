package com.dardan.rrafshi.commons.security;

import com.dardan.rrafshi.commons.exceptions.ApplicationException;


public final class KeystoreException
{
	private KeystoreException() {}


	public static class KeystoreNotFound extends ApplicationException
	{
		private static final long serialVersionUID = 1L;


		public KeystoreNotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public KeystoreNotFound(final String message)
		{
			super(message);
		}
	}

	public static class KeyNotFound extends ApplicationException
	{
		private static final long serialVersionUID = 1L;


		public KeyNotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public KeyNotFound(final String message)
		{
			super(message);
		}
	}

	public static class KeyAlreadyExist extends ApplicationException
	{
		private static final long serialVersionUID = 1L;


		public KeyAlreadyExist(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public KeyAlreadyExist(final String message)
		{
			super(message);
		}
	}
}
