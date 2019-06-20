package com.dardan.rrafshi.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Memory
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Memory.class);


	private Memory() {}


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

	public static boolean isMemoryUsageExceeded(final long threshold)
	{
		final double usedMemory = getUsedMemory() / 1000000.0;

		if(usedMemory >= threshold)
			return true;
		else
			return false;
	}


	public static void printMemoryUsage()
	{
		final double totalMemory = getTotalMemory() / 1000000.0;
		final double freeMemory = getFreeMemory() / 1000000.0;
		final double usedMemory = getUsedMemory() / 1000000.0;

		LOGGER.info("Total memory: " + totalMemory + " MB");
		LOGGER.info("Free memory: " + freeMemory + " MB");
		LOGGER.info("Used memory: " + usedMemory + " MB");
	}
}
