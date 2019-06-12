package com.dardan.rrafshi.commons;

import java.util.List;
import java.util.Random;


public final class Randomizer
{
	private Randomizer() {}


	public static long generateLong(final long lower, final long upper)
	{
		if(upper < lower)
			throw new IllegalArgumentException("upper boundary must be greater or equal lower boundary");

		if(lower < 0)
			throw new IllegalArgumentException("both boundaries must be positive");

		if(lower == upper)
			return lower;

		final Random random = new Random(System.nanoTime());
		return lower + random.nextLong() * (upper - lower + 1);
	}

	public static long generateLong(final long upper)
	{
		return generateLong(0, upper);
	}

	public static long generateLong()
	{
		return generateLong(Long.MAX_VALUE);
	}

	public static long[] generateLongs(final int size)
	{
		if(size < 0)
			throw new IllegalArgumentException("size must be positive");

		final long[] data = new long[size];
		for(int i = 0; i < data.length; i++)
			data[i] = generateLong();

		return data;
	}


	public static int generateInteger(final int lower, final int upper)
	{
		if(upper < lower)
			throw new IllegalArgumentException("upper boundary must be greater or equal lower boundary");

		if(lower < 0)
			throw new IllegalArgumentException("both boundaries must be positive");

		if(lower == upper)
			return lower;

		final Random random = new Random(System.nanoTime());
		return random.nextInt(upper - lower + 1) + lower;
	}

	public static int generateInteger(final int upper)
	{
		return generateInteger(0, upper);
	}

	public static int generateInteger()
	{
		return generateInteger(Integer.MAX_VALUE);
	}

	public static int[] generateIntegers(final int size)
	{
		if(size < 0)
			throw new IllegalArgumentException("size must be positive");

		final int[] data = new int[size];
		for(int i = 0; i < data.length; i++)
			data[i] = generateInteger();

		return data;
	}


	public static double generateDouble(final double lower, final double upper)
	{
		if(upper < lower)
			throw new IllegalArgumentException("upper boundary must be greater or equal lower boundary");

		if(lower < 0)
			throw new IllegalArgumentException("both boundaries must be positive");

		if(lower == upper)
			return lower;

		final Random random = new Random(System.nanoTime());
		return lower + random.nextDouble() * (upper - lower + 1);
	}

	public static double generateDouble(final double upper)
	{
		return generateDouble(0, upper);
	}

	public static double generateDouble()
	{
		return generateDouble(Double.MAX_VALUE);
	}

	public static double[] generateDoubles(final int size)
	{
		if(size < 0)
			throw new IllegalArgumentException("size must be positive");

		final double[] data = new double[size];
		for(int i = 0; i < data.length; i++)
			data[i] = generateDouble();

		return data;
	}


	public static float generateFloat(final float lower, final float upper)
	{
		if(upper < lower)
			throw new IllegalArgumentException("upper boundary must be greater or equal lower boundary");

		if(lower < 0)
			throw new IllegalArgumentException("both boundaries must be positive");

		if(lower == upper)
			return lower;

		final Random random = new Random(System.nanoTime());
		return lower + random.nextFloat() * (upper - lower + 1);
	}

	public static float generateFloat(final float upper)
	{
		return generateFloat(0, upper);
	}

	public static float generateFloat()
	{
		return generateFloat(Float.MAX_VALUE);
	}

	public static float[] generateFloats(final int size)
	{
		if(size < 0)
			throw new IllegalArgumentException("size must be positive");

		final float[] data = new float[size];
		for(int i = 0; i < data.length; i++)
			data[i] = generateFloat();

		return data;
	}


	public static byte[] generateBytes(final int size)
	{
		if(size < 0)
			throw new IllegalArgumentException("size must be positive");

		final byte[] data = new byte[size];
		final Random random = new Random(System.nanoTime());
		random.nextBytes(data);

		return data;
	}

	public static boolean generateBoolean()
	{
		final Random random = new Random(System.nanoTime());
		return random.nextBoolean();
	}


	public static <T> T anyOf(final T[] items)
	{
		if(items == null || items.length == 0)
			return null;

		return items[generateInteger(items.length)];
	}

	public static <T> T anyOf(final List<T> items)
	{
		if(items == null || items.size() == 0)
			return null;

		return items.get(generateInteger(items.size()));
	}
}
