package com.dardan.rrafshi.commons;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Performance
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Performance.class);
	private static final Map<String, TimingEntry> TIMING_MAP = new HashMap<>();


	private Performance() {}


	public static void startMeasure(final String name)
	{
		TIMING_MAP.put(name, new TimingEntry(System.nanoTime()));
	}

	public static void stopMeasure(final String name)
	{
		final TimingEntry timingEntry = getTimingEntry(name);
		timingEntry.setStopTime(System.nanoTime());
	}

	public static void printTimeResult(final String name)
	{
		final TimingEntry timingEntry = getTimingEntry(name);
		printTimeResult(name, timingEntry.startTime, timingEntry.stopTime);
	}

	public static void printTimeResult(final String info, final long begin, final long end)
	{
		LOGGER.info(info + " took " + TimeUnit.NANOSECONDS.toMillis(end - begin) + " ms");
	}

	private static TimingEntry getTimingEntry(final String name)
	{
		final TimingEntry timingEntry = TIMING_MAP.get(name);

		if(timingEntry == null)
			throw new IllegalArgumentException("No data for '" + name + "'");

		return timingEntry;
	}


	private static final class TimingEntry
	{
		private final long startTime;
		private long stopTime;

		public TimingEntry(final long startTime)
		{
			this.startTime = startTime;
		}

		public void setStopTime(final long stopTime)
		{
			this.stopTime = stopTime;
		}

		@Override
		public boolean equals(final Object object)
		{
			if(object == null) return false;
			if(this == object) return true;

			if(this.getClass() != object.getClass())
				return false;

			final TimingEntry entry = (TimingEntry) object;
			return this.startTime == entry.startTime
				&& this.stopTime == entry.stopTime;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(this.startTime);
		}
	}
}
