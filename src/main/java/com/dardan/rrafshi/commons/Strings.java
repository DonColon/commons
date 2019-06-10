package com.dardan.rrafshi.commons;

import java.util.Locale;

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

	public static boolean isNotAlpha(final String value)
	{
		return !isAlpha(value);
	}

	public static boolean isNumber(final String value)
	{
		if(value == null)
			return false;
		else
			return value.matches("-?\\d+(\\.\\d+)?");
	}

	public static boolean isNotNumber(final String value)
	{
		return !isNumber(value);
	}

	public static boolean isNumeric(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isDigit);
	}

	public static boolean isNotNumeric(final String value)
	{
		return !isNumeric(value);
	}

	public static boolean isAlphanumeric(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isLetterOrDigit);
	}

	public static boolean isNotAlphanumeric(final String value)
	{
		return !isAlphanumeric(value);
	}

	public static boolean isWhitespace(final String value)
	{
		if(value == null)
			return false;
		else
			return value.chars().allMatch(Character::isWhitespace);
	}

	public static boolean isNotWhitespace(final String value)
	{
		return !isWhitespace(value);
	}


	public static String trim(final String value)
	{
		if(value == null)
			return null;
		else
			return value.trim();
	}

	public static boolean startsWith(final String value, final String prefix)
	{
		if(value == null || prefix == null)
			return false;
		else
			return value.startsWith(prefix);
	}

	public static boolean startsWithAny(final String value, final String... prefixesToSearch)
	{
		for(final String prefix : prefixesToSearch)
			if(startsWith(value, prefix))
				return true;

		return false;
	}

	public static boolean endsWith(final String value, final String suffix)
	{
		if(value == null || suffix == null)
			return false;
		else
			return value.endsWith(suffix);
	}

	public static boolean endsWithAny(final String value, final String... suffixesToSearch)
	{
		for(final String suffix : suffixesToSearch)
			if(endsWith(value, suffix))
				return true;

		return false;
	}

	public static int indexOf(final String value, final String stringToSearch)
	{
		if(value == null || stringToSearch == null)
			return -1;
		else
			return value.indexOf(stringToSearch);
	}

	public static int indexOf(final String value, final char characterToSearch)
	{
		return indexOf(value, String.valueOf(characterToSearch));
	}

	public static int lastIndexOf(final String value, final String stringToSearch)
	{
		if(value == null || stringToSearch == null)
			return -1;
		else
			return value.lastIndexOf(stringToSearch);
	}

	public static int lastIndexOf(final String value, final char characterToSearch)
	{
		return lastIndexOf(value, String.valueOf(characterToSearch));
	}

	public static boolean contains(final String value, final String stringToSearch)
	{
		if(value == null || stringToSearch == null)
			return false;
		else
			return value.contains(stringToSearch);
	}

	public static boolean contains(final String value, final char characterToSearch)
	{
		return contains(value, String.valueOf(characterToSearch));
	}

	public static boolean containsAny(final String value, final String... stringsToSearch)
	{
		for(final String stringToSearch : stringsToSearch)
			if(contains(value, stringToSearch))
				return true;

		return false;
	}

	public static String substring(final String value, final int start, final int end)
	{
		if(value == null)
			return null;
		else
			return value.substring(start, end);
	}

	public static String substring(final String value, final int start)
	{
		if(value == null)
			return null;
		else
			return value.substring(start);
	}

	public static String[] split(final String value, final String delimiter)
	{
		if(value == null)
			return null;

		if(delimiter == null)
			return split(value);

		return value.split(delimiter);
	}

	public static String[] split(final String value, final char delimiter)
	{
		return split(value, String.valueOf(delimiter));
	}

	public static String[] split(final String value)
	{
		return split(value, " ");
	}

	public static String replace(final String value, final String target, final String replacement)
	{
		if(value == null)
			return null;

		if(target == null || replacement == null)
			return value;

		return value.replace(target, replacement);
	}

	public static String replace(final String value, final char target, final char replacement)
	{
		return replace(value, String.valueOf(target), String.valueOf(replacement));
	}

	public static String upperCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;
		else
			return value.toUpperCase(locale);
	}

	public static String upperCase(final String value)
	{
		return upperCase(value, Locale.getDefault());
	}

	public static String lowerCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;
		else
			return value.toLowerCase(locale);
	}

	public static String lowerCase(final String value)
	{
		return lowerCase(value, Locale.getDefault());
	}

	public static String capitalize(final String value)
	{
		if(value == null)
			return null;
		else
			return Character.toTitleCase(value.charAt(0)) + value.substring(1);
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

		return value.substring(0, maxWidth);
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
			return value.substring(wrapToken.length(), value.length() - wrapToken.length());
		} else {
			return value;
		}
	}

	public static String unwrap(final String value, final char wrapToken)
	{
		return unwrap(value, String.valueOf(wrapToken));
	}
}
