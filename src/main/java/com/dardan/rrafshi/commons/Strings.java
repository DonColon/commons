package com.dardan.rrafshi.commons;

public final class Strings
{
	private Strings() {}


	public static boolean isBlank(final String value)
	{
		if(value == null || value.trim().length() == 0)
			return true;
		else
			return false;
	}

	public static boolean isNotBlank(final String value)
	{
		return !isBlank(value);
	}

	public static boolean isEmpty(final String value)
	{
		if(value == null || value.length() == 0)
			return true;
		else
			return false;
	}

	public static boolean isNotEmpty(final String value)
	{
		return !isEmpty(value);
	}

	public static CharSequence removeCharacter(final String value, final String character)
	{
		if(value == null || character == null)
			return null;

		return String.join("", value.split(character));
	}
}
