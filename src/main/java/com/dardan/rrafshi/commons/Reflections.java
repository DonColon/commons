package com.dardan.rrafshi.commons;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Reflections
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Reflections.class);


	private Reflections() {}


	public static void makeAccessible(final AccessibleObject object)
	{
		if(!object.isAccessible())
			object.setAccessible(true);
	}

	public static Class<?> getGenericType(final Class<?> classType, final int index)
	{
		if(classType == null)
			return null;

		final Type genericType = classType.getGenericSuperclass();

		if(!(genericType instanceof ParameterizedType))
			return null;

		final ParameterizedType type = (ParameterizedType) genericType;
		final Type[] types =  type.getActualTypeArguments();

		if(index < 0 || index >= types.length)
			return null;

		if(!(types[index] instanceof Class))
			return null;

		return (Class<?>) types[index];
	}

	public static Class<?> getGenericType(final Class<?> classType)
	{
		return getGenericType(classType, 0);
	}


	public static Field getField(final Class<?> classType, final String name)
	{
		if(Strings.isBlank(name))
			return null;

		for(Class<?> parentType = classType; parentType != null; parentType = parentType.getSuperclass()) {
			try {
				return parentType.getDeclaredField(name);

			} catch (NoSuchFieldException | SecurityException exception) {

				// Continue the search, because the field might be in the parent class
			}
		}

		return null;
	}

	public static List<Field> getFields(final Class<?> classType, final Predicate<? super Field> filter)
	{
		final List<Field> fields = new ArrayList<>();

		for(Class<?> parentType = classType; parentType != null; parentType = parentType.getSuperclass())
			for(final Field field : parentType.getDeclaredFields())
				if(filter == null || filter.test(field))
					fields.add(field);

		return fields;
	}

	public static List<Field> getFields(final Class<?> classType)
	{
		return getFields(classType, null);
	}

	public static Object getFieldValue(final Class<?> classType, final String name)
	{
		final Field field = getField(classType, name);

		if(field == null)
			return null;

		makeAccessible(field);

		try {
			return field.get(null);

		} catch (final IllegalAccessException exception) {

			return null;
		}
	}

	public static Object getFieldValue(final Object target, final String name)
	{
		final Field field = getField(target.getClass(), name);

		if(field == null)
			return null;

		makeAccessible(field);

		try {
			return field.get(target);

		} catch (final IllegalAccessException exception) {

			return null;
		}
	}

	public static void setFieldValue(final Class<?> classType, final String name, final Object value)
	{
		final Field field = getField(classType, name);

		if(field == null)
			return;

		makeAccessible(field);

		try {
			field.set(null, value);

		} catch (final IllegalAccessException exception) {

			LOGGER.error("Failed to set field '" + name + "' with value '" + value + "'", exception);
		}
	}

	public static void setFieldValue(final Object target, final String name, final Object value)
	{
		final Field field = getField(target.getClass(), name);

		if(field == null)
			return;

		makeAccessible(field);

		try {
			field.set(target, value);

		} catch (final IllegalAccessException exception) {

			LOGGER.error("Failed to set field '" + name + "' with value '" + value + "'", exception);
		}
	}


	public static Method getMethod(final Class<?> classType, final String name, final Class<?>... parameterTypes)
	{
		if(Strings.isBlank(name))
			return null;

		for(Class<?> parentType = classType; parentType != null; parentType = parentType.getSuperclass()) {
			try {
				return parentType.getDeclaredMethod(name, parameterTypes);

			} catch (NoSuchMethodException | SecurityException exception) {

				// Continue the search, because the field might be in the parent class
			}
		}

		return null;
	}

	public static List<Method> getMethods(final Class<?> classType, final Predicate<? super Method> filter)
	{
		final List<Method> methods = new ArrayList<>();

		for(Class<?> parentType = classType; parentType != null; parentType = parentType.getSuperclass())
			for(final Method method : parentType.getDeclaredMethods())
				if(filter == null || filter.test(method))
					methods.add(method);

		return methods;
	}

	public static List<Method> getMethods(final Class<?> classType)
	{
		return getMethods(classType, null);
	}

	public static Method getGetter(final Class<?> classType, final String name, final Class<?> returnType)
	{
		if(Strings.isBlank(name))
			return null;

		if(Strings.matches(name, "^[a-z][a-zA-Z0-9]+$"))
			return null;

		if(returnType == boolean.class)
			return getMethod(classType, "is" + Strings.capitalize(name));
		else
			return getMethod(classType, "get" + Strings.capitalize(name));
	}

	public static Method getSetter(final Class<?> classType, final String name, final Class<?> parameterType)
	{
		if(Strings.isBlank(name))
			return null;

		if(Strings.matches(name, "^[a-z][a-zA-Z0-9]+$"))
			return null;

		return getMethod(classType, "set" + Strings.capitalize(name), parameterType);
	}

	public static Object invokeMethod(final Method method, final Object target, final Object... args)
	{
		makeAccessible(method);

		try {
			return method.invoke(target, args);

		} catch (InvocationTargetException | IllegalAccessException exception) {

			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <R> R getProperty(final Object target, final String name, final Class<? extends R> returnType)
	{
		final Method getter = getGetter(target.getClass(), name, returnType);

		if(getter == null)
			return null;

		return (R) invokeMethod(getter, target);
	}

	public static <T> void setProperty(final Object target, final String name, final Class<? super T> parameterType, final T value)
	{
		final Method setter = getSetter(target.getClass(), name, parameterType);

		if(setter == null)
			return;

		invokeMethod(setter, target, value);
	}
}
