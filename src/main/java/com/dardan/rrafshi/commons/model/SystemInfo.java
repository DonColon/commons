package com.dardan.rrafshi.commons.model;

import java.util.Objects;


public final class SystemInfo
{
	private final String name;
	private final String version;
	private final String architecture;


	public SystemInfo(final String name, final String version, final String architecture)
	{
		this.name = name;
		this.version = version;
		this.architecture = architecture;
	}


	@Override
	public String toString()
	{
		return "SystemInfo [name=" + this.name + ", version=" + this.version
				+ ", architecture=" + this.architecture + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (object == null) return false;
		if (this == object) return true;

		if (this.getClass() != object.getClass())
			return false;

		final SystemInfo other = (SystemInfo) object;
		return Objects.equals(this.architecture, other.architecture)
			&& Objects.equals(this.name, other.name)
			&& Objects.equals(this.version, other.version);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.architecture, this.name, this.version);
	}


	public String getName()
	{
		return this.name;
	}

	public String getVersion()
	{
		return this.version;
	}

	public String getArchitecture()
	{
		return this.architecture;
	}
}
