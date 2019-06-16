package com.dardan.rrafshi.commons.reflect;

import com.dardan.rrafshi.commons.exceptions.ApplicationRuntimeException;


public final class ReflectException
{
	private ReflectException() {}


	public static class FieldNotFound extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public FieldNotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public FieldNotFound(final String message)
		{
			super(message);
		}
	}

	public static class MethodNotFound extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public MethodNotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public MethodNotFound(final String message)
		{
			super(message);
		}
	}

	public static class GenericTypeNotFound extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public GenericTypeNotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public GenericTypeNotFound(final String message)
		{
			super(message);
		}
	}

	public static class AssigningFailed extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public AssigningFailed(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public AssigningFailed(final String message)
		{
			super(message);
		}
	}
}
