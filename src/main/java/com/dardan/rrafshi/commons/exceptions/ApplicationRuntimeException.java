package com.dardan.rrafshi.commons.exceptions;


public abstract class ApplicationRuntimeException extends RuntimeException
{
	private static final long serialVersionUID = 1L;


	public ApplicationRuntimeException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public ApplicationRuntimeException(final String message)
	{
		super(message);
	}
}
