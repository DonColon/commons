package com.dardan.rrafshi.commons;

public final class Memory
{
	public static long getTotalMemory()
	{
		final Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory();
	}

	public static long getFreeMemory()
	{
		final Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory();
	}

	public static long getUsedMemory()
	{
		return getTotalMemory() - getFreeMemory();
	}

	private Memory() {}
}
