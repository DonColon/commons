package com.dardan.rrafshi.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.model.ByteUnit;


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

	public static boolean isMemoryUsageExceeded(final long threshold, final ByteUnit unit)
	{
		final double usedMemory = getUsedMemory();

		if(usedMemory >= unit.toByte(threshold))
			return true;
		else
			return false;
	}


	public static void printMemoryUsage(final ByteUnit unit)
	{
		final long totalMemory = unit.convert(getTotalMemory(), ByteUnit.BYTE);
		final long freeMemory = unit.convert(getFreeMemory(), ByteUnit.BYTE);
		final long usedMemory = unit.convert(getUsedMemory(), ByteUnit.BYTE);

		LOGGER.info("Total memory: " + totalMemory + " " + unit.getAbbreviation());
		LOGGER.info("Free memory: " + freeMemory + " " + unit.getAbbreviation());
		LOGGER.info("Used memory: " + usedMemory + " " + unit.getAbbreviation());
	}
}
