package com.dardan.rrafshi.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public final class RandomizerTest
{
	@RepeatedTest(10)
	@DisplayName("generate long value between x and y")
	public void generateLongBetweenBoundaries()
	{
		final long lower = 1;
		final long upper = 10;

		final long value = Randomizer.generateLong(lower, upper);
		assertTrue(value >= lower && value <= upper);
	}

	@Test
	@DisplayName("generate long value between x and y throws exception")
	public void generateLongBetweenBoundariesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateLong(10, 1));
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateLong(-10, 1));
	}

	@Test
	@DisplayName("generate long value between same value")
	public void generateLongBetweenSameValue()
	{
		final long boundary = 10;

		final long value = Randomizer.generateLong(boundary, boundary);
		assertEquals(boundary, value);
	}

	@RepeatedTest(10)
	@DisplayName("generate long value between 0 and x")
	public void generateLongBetweenZeroAndUpper()
	{
		final long upper = 10;

		final long value = Randomizer.generateLong(upper);
		assertTrue(value >= 0 && value <= upper);
	}

	@RepeatedTest(10)
	@DisplayName("generate long value between 0 and max value")
	public void generateLongBetweenZeroAndMax()
	{
		final long value = Randomizer.generateLong();
		assertTrue(value >= 0 && value <= Long.MAX_VALUE);
	}

	@RepeatedTest(10)
	@DisplayName("generate long values between 0 and max value")
	public void generateLongValues()
	{
		final long[] data = Randomizer.generateLongs(10);
		for(int i = 0; i < data.length; i++)
			assertTrue(data[i] >= 0 && data[i] <= Long.MAX_VALUE);
	}

	@Test
	@DisplayName("generate long values between 0 and max value throws exception")
	public void generateLongValuesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateLongs(-10));
	}


	@RepeatedTest(10)
	@DisplayName("generate integer value between x and y")
	public void generateIntegerBetweenBoundaries()
	{
		final int lower = 1;
		final int upper = 10;

		final int value = Randomizer.generateInteger(lower, upper);
		assertTrue(value >= lower && value <= upper);
	}

	@Test
	@DisplayName("generate integer value between x and y throws exception")
	public void generateIntegerBetweenBoundariesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateInteger(10, 1));
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateInteger(-10, 1));
	}

	@Test
	@DisplayName("generate integer value between same value")
	public void generateIntegerBetweenSameValue()
	{
		final int boundary = 10;

		final int value = Randomizer.generateInteger(boundary, boundary);
		assertEquals(boundary, value);
	}

	@RepeatedTest(10)
	@DisplayName("generate integer value between 0 and x")
	public void generateIntegerBetweenZeroAndUpper()
	{
		final int upper = 10;

		final int value = Randomizer.generateInteger(upper);
		assertTrue(value >= 0 && value <= upper);
	}

	@RepeatedTest(10)
	@DisplayName("generate integer value between 0 and max value")
	public void generateIntegerBetweenZeroAndMax()
	{
		final int value = Randomizer.generateInteger();
		assertTrue(value >= 0 && value <= Integer.MAX_VALUE);
	}

	@RepeatedTest(10)
	@DisplayName("generate integer values between 0 and max value")
	public void generateIntegerValues()
	{
		final int[] data = Randomizer.generateIntegers(10);
		for(int i = 0; i < data.length; i++)
			assertTrue(data[i] >= 0 && data[i] <= Integer.MAX_VALUE);
	}

	@Test
	@DisplayName("generate integer values between 0 and max value throws exception")
	public void generateIntegerValuesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateIntegers(-10));
	}


	@RepeatedTest(10)
	@DisplayName("generate double value between x and y")
	public void generateDoubleBetweenBoundaries()
	{
		final double lower = 1.5;
		final double upper = 9.5;

		final double value = Randomizer.generateDouble(lower, upper);
		assertTrue(value >= lower && value <= upper);
	}

	@Test
	@DisplayName("generate double value between x and y throws exception")
	public void generateDoubleBetweenBoundariesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateDouble(10, 1));
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateDouble(-10, 1));
	}

	@Test
	@DisplayName("generate double value between same value")
	public void generateDoubleBetweenSameValue()
	{
		final double boundary = 10;

		final double value = Randomizer.generateDouble(boundary, boundary);
		assertEquals(boundary, value);
	}

	@RepeatedTest(10)
	@DisplayName("generate double value between 0 and x")
	public void generateDoubleBetweenZeroAndUpper()
	{
		final double upper = 9.5;

		final double value = Randomizer.generateDouble(upper);
		assertTrue(value >= 0 && value <= upper);
	}

	@RepeatedTest(10)
	@DisplayName("generate double value between 0 and max value")
	public void generateDoubleBetweenZeroAndMax()
	{
		final double value = Randomizer.generateDouble();
		assertTrue(value >= 0 && value <= Double.MAX_VALUE);
	}

	@RepeatedTest(10)
	@DisplayName("generate double values between 0 and max value")
	public void generateDoubleValues()
	{
		final double[] data = Randomizer.generateDoubles(10);
		for(int i = 0; i < data.length; i++)
			assertTrue(data[i] >= 0 && data[i] <= Double.MAX_VALUE);
	}

	@Test
	@DisplayName("generate double values between 0 and max value throws exception")
	public void generateDoubleValuesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateDoubles(-10));
	}


	@RepeatedTest(10)
	@DisplayName("generate float value between x and y")
	public void generateFloatBetweenBoundaries()
	{
		final float lower = 1.5f;
		final float upper = 9.5f;

		final float value = Randomizer.generateFloat(lower, upper);
		assertTrue(value >= lower && value <= upper);
	}

	@Test
	@DisplayName("generate float value between x and y throws exception")
	public void generateFloatBetweenBoundariesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateFloat(10, 1));
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateFloat(-10, 1));
	}

	@Test
	@DisplayName("generate float value between same value")
	public void generateFloatBetweenSameValue()
	{
		final float boundary = 10;

		final float value = Randomizer.generateFloat(boundary, boundary);
		assertEquals(boundary, value);
	}

	@RepeatedTest(10)
	@DisplayName("generate float value between 0 and x")
	public void generateFloatBetweenZeroAndUpper()
	{
		final float upper = 9.5f;

		final float value = Randomizer.generateFloat(upper);
		assertTrue(value >= 0 && value <= upper);
	}

	@RepeatedTest(10)
	@DisplayName("generate float value between 0 and max value")
	public void generateFloatBetweenZeroAndMax()
	{
		final float value = Randomizer.generateFloat();
		assertTrue(value >= 0 && value <= Float.MAX_VALUE);
	}

	@RepeatedTest(10)
	@DisplayName("generate float values between 0 and max value")
	public void generateFloatValues()
	{
		final float[] data = Randomizer.generateFloats(10);
		for(int i = 0; i < data.length; i++)
			assertTrue(data[i] >= 0 && data[i] <= Float.MAX_VALUE);
	}

	@Test
	@DisplayName("generate float values between 0 and max value throws exception")
	public void generateFloatValuesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateFloats(-10));
	}


	@RepeatedTest(10)
	@DisplayName("generate bytes between min value and max value")
	public void generateBytes()
	{
		final byte[] data = Randomizer.generateBytes(10);
		for(int i = 0; i < data.length; i++)
			assertTrue(data[i] >= Byte.MIN_VALUE && data[i] <= Byte.MAX_VALUE);
	}

	@Test
	@DisplayName("generate byte values between 0 and max value throws exception")
	public void generateBytesThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> Randomizer.generateBytes(-10));
	}

	@RepeatedTest(10)
	@DisplayName("generate boolean value")
	public void generateBoolean()
	{
		final boolean value = Randomizer.generateBoolean();
		assertTrue(value || !value);
	}


	@RepeatedTest(10)
	@DisplayName("select random element from array")
	public void selectRandomElementFromArray()
	{
		final Integer[] values = {1, 5, 7, 8, 10, 20, 11, 14, 34, 56};
		final int value = Randomizer.anyOf(values);

		boolean contains = false;
		for(int i = 0; i < values.length; i++) {
			if(value == values[i]) {
				contains = true;
				break;
			}
		}
		assertTrue(contains);
	}

	@Test
	@DisplayName("select random element from array returns null")
	public void selectRandomElementFromArrayReturnsNull()
	{
		assertNull(Randomizer.anyOf(new String[] {}));
	}

	@RepeatedTest(10)
	@DisplayName("select random element from list")
	public void selectRandomElementFromList()
	{
		final List<String> values = Arrays.asList("Dardan", "Hasan", "Martin", "Maik", "Simon");
		final String value = Randomizer.anyOf(values);

		assertTrue(values.contains(value));
	}

	@Test
	@DisplayName("select random element from list returns null")
	public void selectRandomElementFromListReturnsNull()
	{
		final List<String> values = new ArrayList<>();
		final List<String> data = null;

		assertNull(Randomizer.anyOf(values));
		assertNull(Randomizer.anyOf(data));
	}
}
