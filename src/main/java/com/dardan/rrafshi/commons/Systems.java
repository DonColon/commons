package com.dardan.rrafshi.commons;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Locale;

import com.dardan.rrafshi.commons.model.JavaVersion;
import com.dardan.rrafshi.commons.model.OperatingSystem;


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

	public static OperatingSystem getOperatingSystem()
	{
		final Runtime runtime = Runtime.getRuntime();

		final String name = getSystemProperty("os.name");
		final String version = getSystemProperty("os.version");
		final String architecture = getSystemProperty("os.arch");

		return new OperatingSystem(name, version, architecture, runtime.availableProcessors());
	}

	public static JavaVersion getJavaVersion()
	{
		final String version = getSystemProperty("java.version");
		final String vmVersion = getSystemProperty("java.vm.version");
		final String runtimeVersion = getSystemProperty("java.runtime.version");

		final String specificationVersion = getSystemProperty("java.specification.version");
		final String vmSpecificationVersion = getSystemProperty("java.vm.specification.version");

		return new JavaVersion(version, vmVersion, runtimeVersion, specificationVersion, vmSpecificationVersion);
	}

	public static Path getHomePath()
	{
		return Paths.get(getSystemProperty("user.home"));
	}

	public static Path getDownloadsPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Downloads");
	}

	public static Path getDesktopPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Desktop");
	}

	public static Path getDocumentsPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Documents");
	}

	public static Path getPicturesPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Pictures");
	}

	public static Path getVideosPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Videos");
	}

	public static Path getMusicPath()
	{
		final Path homePath = getHomePath();
		return homePath.resolve("Music");
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

	public static Path getJavaLibraryPath()
	{
		return Paths.get(getSystemProperty("java.ext.dirs"));
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
