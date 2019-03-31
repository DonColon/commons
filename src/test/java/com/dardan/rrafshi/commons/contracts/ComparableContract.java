package com.dardan.rrafshi.commons.contracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public interface ComparableContract<T extends Comparable<T>> extends Testable<T>
{
	T createSmallerValue();

	@Test
	@DisplayName("Returns zero when compared to itself")
	default void returnsZeroWhenComparedToItself()
	{
		final T value = createValue();
		assertEquals(0, value.compareTo(value));
	}

	@Test
	@DisplayName("Returns positive value when compared to smaller value")
	default void returnsPositiveWhenComparedToSmallerValue()
	{
		final T value = createValue();
		final T smallerValue = createSmallerValue();
		assertTrue(value.compareTo(smallerValue) > 0);
	}

	@Test
	@DisplayName("Returns negative value when compared to larger value")
	default void returnsNegativeWhenComparedToLargerValue()
	{
		final T value = createValue();
		final T smallerValue = createSmallerValue();
		assertTrue(smallerValue.compareTo(value) < 0);
	}
}
