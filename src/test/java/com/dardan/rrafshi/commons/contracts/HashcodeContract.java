package com.dardan.rrafshi.commons.contracts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public interface HashcodeContract<T> extends Testable<T>
{
	T createNotEqualValue();

	@Test
	@DisplayName("Same hashcode if value equals same value")
	default void hashcodeEqualsIfSameValue()
	{
		final T value = createValue();
		final T sameValue = createValue();
		assertEquals(value.hashCode(), sameValue.hashCode());
	}

	@Test
	@DisplayName("Different hashcode if value does not equals different value")
	default void hashcodeNotEqualsIfDifferentValue()
	{
		final T value = createValue();
		final T differentValue = createNotEqualValue();
		assertNotEquals(value.hashCode(), differentValue.hashCode());
	}

}
