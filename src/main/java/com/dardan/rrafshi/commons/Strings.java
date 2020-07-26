package com.dardan.rrafshi.commons;

import java.util.Collection;
import java.util.Locale;


public final class Strings
{
	private Strings() {}


	public static boolean equals(final String value, final String other)
	{
		if(value == null || other == null)
			return false;

		if(value.equals(other))
			return true;
		else
			return false;
	}

	public static boolean equalsAny(final String value, final String... others)
	{
		for(final String other : others)
			if(equals(value, other))
				return true;

		return false;
	}

	public static boolean notEquals(final String value, final String other)
	{
		return !equals(value, other);
	}

	public static boolean equalsNone(final String value, final String... others)
	{
		return !equalsAny(value, others);
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

	public static boolean startsNotWith(final String value, final String prefix)
	{
		return !startsWith(value, prefix);
	}

	public static boolean startsWithNone(final String value, final String... prefixesToSearch)
	{
		return !startsWithAny(value, prefixesToSearch);
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

	public static boolean endsNotWith(final String value, final String suffix)
	{
		return !endsWith(value, suffix);
	}

	public static boolean endsWithNone(final String value, final String... suffixesToSearch)
	{
		return !endsWithAny(value, suffixesToSearch);
	}

	public static boolean matches(final String value, final String pattern)
	{
		if(value == null || pattern == null)
			return false;
		else
			return value.matches(pattern);
	}

	public static boolean matchesAny(final String value, final String... patterns)
	{
		for(final String pattern : patterns)
			if(matches(value, pattern))
				return true;

		return false;
	}

	public static boolean matchesNot(final String value, final String pattern)
	{
		return !matches(value, pattern);
	}

	public static boolean matchesNone(final String value, final String... patterns)
	{
		return !matchesAny(value, patterns);
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

	public static boolean containsAny(final String value, final char... charactersToSearch)
	{
		for(final char character : charactersToSearch)
			if(contains(value, character))
				return true;

		return false;
	}

	public static boolean containsNot(final String value, final String stringToSearch)
	{
		return !contains(value, stringToSearch);
	}

	public static boolean containsNot(final String value, final char characterToSearch)
	{
		return !contains(value, characterToSearch);
	}

	public static boolean containsNone(final String value, final String... stringsToSearch)
	{
		return !containsAny(value, stringsToSearch);
	}

	public static boolean containsNone(final String value, final char... charactersToSearch)
	{
		return !containsAny(value, charactersToSearch);
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

	public static String upperSnakeCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String snakeCase = value.replaceAll("\\s+", "_");

		return snakeCase.toUpperCase(locale);
	}

	public static String upperSnakeCase(final String value)
	{
		return upperSnakeCase(value, Locale.getDefault());
	}

	public static String lowerSnakeCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String snakeCase = value.replaceAll("\\s+", "_");

		return snakeCase.toLowerCase(locale);
	}

	public static String lowerSnakeCase(final String value)
	{
		return lowerSnakeCase(value, Locale.getDefault());
	}

	public static String upperKebabCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String kebabCase = value.replaceAll("\\s+", "-");

		return kebabCase.toUpperCase(locale);
	}

	public static String upperKebabCase(final String value)
	{
		return upperKebabCase(value, Locale.getDefault());
	}

	public static String lowerKebabCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String kebabCase = value.replaceAll("\\s+", "-");

		return kebabCase.toLowerCase(locale);
	}

	public static String lowerKebabCase(final String value)
	{
		return lowerKebabCase(value, Locale.getDefault());
	}

	public static String upperCamelCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String[] parts = value.split("\\s+");
		final String start = parts[0].toLowerCase(locale);

		final StringBuilder camelCase = new StringBuilder(capitalize(start));

		for(int i = 1; i < parts.length; i++) {
			final String part = parts[i].toLowerCase(locale);
			camelCase.append(capitalize(part));
		}

		return camelCase.toString();
	}

	public static String upperCamelCase(final String value)
	{
		return upperCamelCase(value, Locale.getDefault());
	}

	public static String lowerCamelCase(final String value, final Locale locale)
	{
		if(value == null)
			return null;

		final String[] parts = value.split("\\s+");
		final String start = parts[0].toLowerCase(locale);

		final StringBuilder builder = new StringBuilder(start);

		for(int i = 1; i < parts.length; i++) {
			final String part = capitalize(parts[i].toLowerCase(locale));
			builder.append(part);
		}

		return builder.toString();
	}

	public static String lowerCamelCase(final String value)
	{
		return lowerCamelCase(value, Locale.getDefault());
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

		if(value.startsWith(wrapToken) && value.endsWith(wrapToken))
			return value.substring(wrapToken.length(), value.length() - wrapToken.length());
		else
			return value;
	}

	public static String unwrap(final String value, final char wrapToken)
	{
		return unwrap(value, String.valueOf(wrapToken));
	}

	public static <T> String valueOf(final Collection<T> values, final String delimiter)
	{
		if(values == null || delimiter == null)
			return null;

		final StringBuilder builder = new StringBuilder();

		for(final T value : values) {
			builder.append(value);
			builder.append(delimiter);
		}

		if(builder.length() > 0)
			builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}

	public static <T> String valueOf(final Collection<T> values)
	{
		return valueOf(values, " ");
	}

	public static String indent(final String value, final int count)
	{
		if(value == null)
			return null;

		if(count == 0)
			return value;

		String indentedValue = value;

		if(count > 0)
			for(int i = 0; i < count; i++)
				indentedValue = " " + indentedValue;
		else
			for(int i = 0; i < count; i++)
				if(Character.isWhitespace(value.charAt(i)))
					indentedValue = value.substring(i);
				else
					break;

		return indentedValue;
	}
}
