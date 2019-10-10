package com.dardan.rrafshi.commons.model;

import java.util.Objects;


public final class OperatingSystem
{
	private final String name;
	private final String version;
	private final String architecture;
	private final int numberOfProcessors;


	public OperatingSystem(final String name, final String version,
		final String architecture, final int numberOfProcessors)
	{
		this.name = name;
		this.version = version;
		this.architecture = architecture;
		this.numberOfProcessors = numberOfProcessors;
	}


	@Override
	public String toString()
	{
		return "OperatingSystem [name=" + this.name + ", version=" + this.version
				+ ", architecture=" + this.architecture + ", numberOfProcessors="
				+ this.numberOfProcessors + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final OperatingSystem other = (OperatingSystem) object;
		return Objects.equals(this.name, other.name)
			&& Objects.equals(this.version, other.version)
			&& Objects.equals(this.architecture, other.architecture)
			&& this.numberOfProcessors == other.numberOfProcessors;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.architecture, this.name,
				this.numberOfProcessors, this.version);
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

	public int getNumberOfProcessors()
	{
		return this.numberOfProcessors;
	}
}
