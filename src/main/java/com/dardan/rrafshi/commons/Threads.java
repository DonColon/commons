package com.dardan.rrafshi.commons;

import java.util.concurrent.TimeUnit;

public final class Threads
{
	public static void safeSleep(final TimeUnit timeUnit, final long duration)
	{
		safeSleep(timeUnit.toMillis(duration));
	}

	public static void safeSleep(final long durationInMilliseconds)
	{
		try {
			Thread.sleep(durationInMilliseconds);

		} catch (final InterruptedException exception) {

			Thread.currentThread().interrupt();
		}
	}

	private Threads() {}
}
