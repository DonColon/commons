package com.dardan.rrafshi.commons;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Locale;

import com.dardan.rrafshi.commons.model.SystemInfo;


public final class Systems
{
	private Systems() {}


	public static Locale getLocale()
	{
		final String language = getSystemProperty("user.language");
		final String country = getSystemProperty("user.country");
		final String variant = getSystemProperty("user.variant");
		final String script = getSystemProperty("user.script");

		return new Locale.Builder()
				.setLanguage(language)
				.setRegion(country)
				.setVariant(variant)
				.setScript(script)
				.build();
	}

	public static ZoneId getTimezone()
	{
		final String timezone = getSystemProperty("user.timezone");
		return ZoneId.of(timezone);
	}

	public static String getUsername()
	{
		return getSystemProperty("user.name");
	}

	public static SystemInfo getSystemInfo()
	{
		final String name = getSystemProperty("os.name");
		final String version = getSystemProperty("os.version");
		final String architecture = getSystemProperty("os.arch");

		return new SystemInfo(name, version, architecture);
	}

	public static Path getHomePath()
	{
		return Paths.get(getSystemProperty("user.home"));
	}

	public static Path getProjectPath()
	{
		return Paths.get(getSystemProperty("user.dir"));
	}

	public static Path getJavaHomePath()
	{
		return Paths.get(getSystemProperty("java.home"));
	}

	public static Path getJavaTemporaryPath()
	{
		return Paths.get(getSystemProperty("java.io.tmpdir"));
	}

	public static Charset getFileEncoding()
	{
		final String encoding = getSystemProperty("file.encoding");
		return Charset.forName(encoding);
	}

	public static String getFilePathSeparator()
	{
		return getSystemProperty("file.separator");
	}

	public static String getLineSeparator()
	{
		return getSystemProperty("line.separator");
	}

	public static String getOsPathSeparator()
	{
		return getSystemProperty("path.separator");
	}

	public static String getJavaVersion()
	{
		return getSystemProperty("java.version");
	}

	public static String getJavaRuntimeVersion()
	{
		return getSystemProperty("java.runtime.version");
	}

	public static String getJavaVmVersion()
	{
		return getSystemProperty("java.vm.version");
	}


	public static String getEnvironmentVariable(final String name)
	{
		if(Strings.isEmpty(name))
			return null;

		try {
			return System.getenv(name);

		} catch (final SecurityException exception) {

			return null;
		}
	}


	private static String getSystemProperty(final String property)
	{
		if(Strings.isEmpty(property))
			return null;

		try {
			return System.getProperty(property);

		} catch (final SecurityException exception) {

			return null;
		}
	}
}
