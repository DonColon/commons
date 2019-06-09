package com.dardan.rrafshi.commons;

public final class Strings
{
	private Strings() {}


	public static boolean isEquals(final String value, final String other)
	{
		if(value == null || other == null)
			return false;

		if(value.equals(other))
			return true;
		else
			return false;
	}

	public static boolean isNotEquals(final String value, final String other)
	{
		return !isEquals(value, other);
	}

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

	public static boolean isAlpha(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isLetter);
	}

	public static boolean isNumeric(final String value)
	{
		if(value == null)
			return false;
		else
			return value.matches("-?\\d+(\\.\\d+)?");
	}

	public static boolean isAlphanumeric(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isLetterOrDigit);
	}

	public static boolean isWhitespace(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isWhitespace);
	}

	public static String remove(final String value, final String substring)
	{
		if(value == null)
			return null;

		if(substring == null)
			return value;

		return String.join("", value.split(substring));
	}

	public static String remove(final String value, final char character)
	{
		return remove(value, String.valueOf(character));
	}

	public static String truncate(final String value, final int maxWidth)
	{
		if(value == null)
			return null;

		if(value.length() <= maxWidth)
			return value;

		return value.substring(0, maxWidth + 1);
	}

	public static String abbreviate(final String value, final int maxWidth)
	{
		if(value == null)
			return null;

		if(value.length() <= maxWidth)
			return value;

		return value.substring(0, maxWidth - 3).concat("...");
	}

	public static String wrap(final String value, final String wrapWith)
	{
		if(value == null)
			return null;

		if(wrapWith == null)
			return value;

		return wrapWith + value + wrapWith;
	}

	public static String wrap(final String value, final char wrapWith)
	{
		return wrap(value, String.valueOf(wrapWith));
	}

	public static String unwrap(final String value, final String wrapToken)
	{
		if(value == null)
			return null;

		if(wrapToken == null)
			return value;

		if(value.startsWith(wrapToken) && value.endsWith(wrapToken)) {
			return value.substring(wrapToken.length() + 1, value.length() - wrapToken.length() - 1);
		} else {
			return value;
		}
	}

	public static String unwrap(final String value, final char wrapToken)
	{
		return unwrap(value, String.valueOf(wrapToken));
	}
}
