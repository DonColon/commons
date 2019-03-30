package com.dardan.rrafshi.commons.contracts;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public interface EqualsContract<T> extends Testable<T>
{
	T createNotEqualValue();

	@Test
	@DisplayName("Value equals itself")
	default void valueEqualsItself()
	{
		final T value = createValue();
		assertEquals(value, value);
	}

	@Test
	@DisplayName("Value does not equal null")
	default void valueDoesNotEqualNull()
	{
		final T value = createValue();
		assertFalse(value.equals(null));
	}

	@Test
	@DisplayName("Value equals same value")
	default void valueEqualsSameValue()
	{
		final T value = createValue();
		final T sameValue = createValue();
		assertEquals(value, sameValue);
		assertEquals(sameValue, value);
	}

	@Test
	@DisplayName("Value does not equal different value")
	default void valueDoesNotEqualDifferentValue()
	{
		final T value = createValue();
		final T differentValue = createNotEqualValue();
		assertNotEquals(value, differentValue);
		assertNotEquals(differentValue, value);
	}
}
