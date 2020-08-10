package com.dardan.rrafshi.commons;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


public final class StringUtilitiesTest
{
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings={" ", "   ", "\n", "\t"})
	@DisplayName("string value is blank")
	public void valueIsBlank(final String value)
	{
		assertTrue(Strings.isBlank(value));
		assertFalse(Strings.isNotBlank(value));
	}

	@ParameterizedTest
	@ValueSource(strings={"Dardan", "Rrafshi", "drrafshi@hotmail.de", "1997-01-30"})
	@DisplayName("string value is not blank")
	public void valueIsNotBlank(final String value)
	{
		assertTrue(Strings.isNotBlank(value));
		assertFalse(Strings.isBlank(value));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("string value is empty")
	public void valueIsEmpty(final String value)
	{
		assertTrue(Strings.isEmpty(value));
		assertFalse(Strings.isNotEmpty(value));
	}

	@ParameterizedTest
	@ValueSource(strings={" ", "\n", "\t", "Dardan"})
	@DisplayName("string value is not empty")
	public void valueIsNotEmpty(final String value)
	{
		assertTrue(Strings.isNotEmpty(value));
		assertFalse(Strings.isEmpty(value));
	}

	@ParameterizedTest
	@ValueSource(strings={"abcde", "fghijk", "lmnop", "qrstuvw", "xyz"})
	@DisplayName("string value is alpha")
	public void valueIsAlpha(final String value)
	{
		assertTrue(Strings.isAlpha(value));
		assertFalse(Strings.isNotAlpha(value));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings={"12345", "6789", "![]/"})
	@DisplayName("string value is not alpha")
	public void valueIsNotAlpha(final String value)
	{
		assertTrue(Strings.isNotAlpha(value));
		assertFalse(Strings.isAlpha(value));
	}

	@ParameterizedTest
	@ValueSource(strings={"42", "-42", "42.5", "-42.37"})
	@DisplayName("string value is number")
	public void valueIsNumber(final String value)
	{
		assertTrue(Strings.isNumber(value));
		assertFalse(Strings.isNotNumber(value));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings={"abcdefg", "2019-06-09", "56€", "$100"})
	@DisplayName("string value is not number")
	public void valueIsNotNumber(final String value)
	{
		assertTrue(Strings.isNotNumber(value));
		assertFalse(Strings.isNumber(value));
	}

	@ParameterizedTest
	@ValueSource(strings={"1234", "5678", "1337", "4711"})
	@DisplayName("string value is numeric")
	public void valueIsNumeric(final String value)
	{
		assertTrue(Strings.isNumeric(value));
		assertFalse(Strings.isNotNumeric(value));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings={"abcdefg", "abc123", "-47.11", "12€"})
	@DisplayName("string value is not numeric")
	public void valueIsNotNumeric(final String value)
	{
		assertTrue(Strings.isNotNumeric(value));
		assertFalse(Strings.isNumeric(value));
	}

	@ParameterizedTest
	@ValueSource(strings={"abcd1234", "efgh789", "12b", "42b"})
	@DisplayName("string value is alphanumeric")
	public void valueIsAlphanumeric(final String value)
	{
		assertTrue(Strings.isAlphanumeric(value));
		assertFalse(Strings.isNotAlphanumeric(value));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings={" ", "\n", "\t", "!?%&"})
	@DisplayName("string value is not alphanumeric")
	public void valueIsNotAlphanumeric(final String value)
	{
		assertTrue(Strings.isNotAlphanumeric(value));
		assertFalse(Strings.isAlphanumeric(value));
	}

	@ParameterizedTest
	@ValueSource(strings={" ", "\n", "\t", "\r"})
	@DisplayName("string value is whitespace")
	public void valueIsWhitespace(final String value)
	{
		assertTrue(Strings.isWhitespace(value));
		assertFalse(Strings.isNotWhitespace(value));
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings={"abcdefg", "12345", "12a", "42€"})
	@DisplayName("string value is not whitespace")
	public void valueIsNotWhitespace(final String value)
	{
		assertTrue(Strings.isNotWhitespace(value));
		assertFalse(Strings.isWhitespace(value));
	}


	@Test
	@DisplayName("trim string value")
	public void trimValue()
	{
		final String expected = "value";
		final String actual = Strings.trim("  \tvalue  ");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("trim string value returns null")
	public void trimValueReturnsNull()
	{
		final String actual = Strings.trim(null);
		assertNull(actual);
	}

	@ParameterizedTest
	@CsvSource(value={"value,val", "messages_de_DE.properties,messages"})
	@DisplayName("string value starts with prefix")
	public void valueStartsWithPrefix(final String value, final String prefix)
	{
		assertTrue(Strings.startsWith(value, prefix));
		assertFalse(Strings.startsNotWith(value, prefix));
	}

	@ParameterizedTest
	@CsvSource(value={"test.png,png", "project.jpg,jpg"})
	@DisplayName("string value ends with suffix")
	public void valueEndsWithSuffix(final String value, final String suffix)
	{
		assertTrue(Strings.endsWith(value, suffix));
	}


	@Test
	@DisplayName("string value to upper snake case")
	public void valueToUpperSnakeCase()
	{
		final String expected = "USER_NAME";
		final String actual = Strings.upperSnakeCase("User Name");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("string value to lower snake case")
	public void valueToLowerSnakeCase()
	{
		final String expected = "user_name";
		final String actual = Strings.lowerSnakeCase("User Name");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("string value to upper kebab case")
	public void valueToUpperKebabCase()
	{
		final String expected = "USER-NAME";
		final String actual = Strings.upperKebabCase("User Name");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("string value to lower kebab case")
	public void valueToLowerKebabCase()
	{
		final String expected = "user-name";
		final String actual = Strings.lowerKebabCase("User NAme");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("string value to upper camel case")
	public void valueToUpperCamelCase()
	{
		final String expected = "UserName";
		final String actual = Strings.upperCamelCase("USer Name");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("string value to lower camel case")
	public void valueToLowerCamelCase()
	{
		final String expected = "userName";
		final String actual = Strings.lowerCamelCase("USer NAme");
		assertEquals(expected, actual);
	}


	@Test
	@DisplayName("remove substring from string value")
	public void removeSubstringFromValue()
	{
		final String expected = "value";
		final String actual = Strings.remove("--value--", "--");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("remove substring from string value returns input")
	public void removeSubstringFromValueReturnsInput()
	{
		final String expected = "--value--";
		final String actual = Strings.remove("--value--", null);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("remove substring from string value returns null")
	public void removeSubstringFromValueReturnsNull()
	{
		final String actual = Strings.remove(null, "--");
		assertNull(actual);
	}

	@Test
	@DisplayName("truncate string value")
	public void truncateValue()
	{
		final String expected = "01234";
		final String actual = Strings.truncate("0123456789", 5);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("truncate string value returns input")
	public void truncateValueReturnsInput()
	{
		final String expected = "01234";
		final String actual = Strings.truncate("01234", 10);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("truncate string value returns null")
	public void truncateValueReturnsNull()
	{
		final String actual = Strings.truncate(null, 10);
		assertNull(actual);
	}

	@Test
	@DisplayName("abbreviate string value")
	public void abbreviateValue()
	{
		final String expected = "01234...";
		final String actual = Strings.abbreviate("0123456789", 8);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("abbreviate string value returns input")
	public void abbreviateValueReturnsInput()
	{
		final String expected = "01234";
		final String actual = Strings.abbreviate("01234", 8);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("abbreviate string value returns null")
	public void abbreviateValueReturnsNull()
	{
		final String actual = Strings.abbreviate(null, 10);
		assertNull(actual);
	}

	@Test
	@DisplayName("wrap string value")
	public void wrapValue()
	{
		final String expected = "*value*";
		final String actual = Strings.wrap("value", "*");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("wrap string value returns input")
	public void wrapValueReturnsInput()
	{
		final String expected = "value";
		final String actual = Strings.wrap("value", null);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("wrap string value returns null")
	public void wrapValueReturnsNull()
	{
		final String actual = Strings.wrap(null, "*");
		assertNull(actual);
	}

	@Test
	@DisplayName("unwrap string value")
	public void unwrapValue()
	{
		final String expected = "value";
		final String actual = Strings.unwrap("*value*", "*");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("unwrap string value returns input")
	public void unwrapValueReturnsInput()
	{
		final String expected = "*value*";
		final String actual = Strings.unwrap("*value*", null);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("unwrap string value returns null")
	public void unwrapValueReturnsNull()
	{
		final String actual = Strings.unwrap(null, "*");
		assertNull(actual);
	}
}
