package com.dardan.rrafshi.commons.exceptions;


public abstract class ApplicationException extends Exception
{
	private static final long serialVersionUID = 1L;


	public ApplicationException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public ApplicationException(final String message)
	{
		super(message);
	}
}
