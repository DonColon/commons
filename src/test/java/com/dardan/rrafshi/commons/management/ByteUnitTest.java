package com.dardan.rrafshi.commons.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public final class ByteUnitTest
{
	@ParameterizedTest
	@DisplayName("convert to byte")
	@CsvFileSource(resources={"/ToByte.csv"})
	public void toByte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toByte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to kilobyte")
	@CsvFileSource(resources={"/ToKilobyte.csv"})
	public void toKilobyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toKilobyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to megabyte")
	@CsvFileSource(resources={"/ToMegabyte.csv"})
	public void toMegabyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toMegabyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to gigabyte")
	@CsvFileSource(resources={"/ToGigabyte.csv"})
	public void toGigabyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toGigabyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to terrabyte")
	@CsvFileSource(resources={"/ToTerrabyte.csv"})
	public void toTerrabyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toTerrabyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to kibibyte")
	@CsvFileSource(resources={"/ToKibibyte.csv"})
	public void toKibibyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toKibibyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to mebibyte")
	@CsvFileSource(resources={"/ToMebibyte.csv"})
	public void toMebibyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toMebibyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to gibibyte")
	@CsvFileSource(resources={"/ToGibibyte.csv"})
	public void toGibibyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toGibibyte(value);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@DisplayName("convert to tebibyte")
	@CsvFileSource(resources={"/ToTebibyte.csv"})
	public void toTebibyte(final String unitName, final long value, final long expected)
	{
		final ByteUnit unit = ByteUnit.valueOf(unitName);
		final long actual = unit.toTebibyte(value);
		assertEquals(expected, actual);
	}
}
