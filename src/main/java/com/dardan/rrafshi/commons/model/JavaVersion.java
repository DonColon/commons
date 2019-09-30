package com.dardan.rrafshi.commons.model;

import java.util.Objects;


public final class JavaVersion
{
	private final String version;
	private final String vmVersion;
	private final String runtimeVersion;

	private final String specificationVersion;
	private final String vmSpecificationVersion;


	public JavaVersion(final String version, final String vmVersion, final String runtimeVersion,
			final String specificationVersion, final String vmSpecificationVersion)
	{
		this.version = version;
		this.vmVersion = vmVersion;
		this.runtimeVersion = runtimeVersion;

		this.specificationVersion = specificationVersion;
		this.vmSpecificationVersion = vmSpecificationVersion;
	}


	@Override
	public String toString()
	{
		return "JavaVersion [version=" + this.version
			 + ", vmVersion=" + this.vmVersion
			 + ", runtimeVersion=" + this.runtimeVersion
			 + ", specificationVersion=" + this.specificationVersion
			 + ", vmSpecificationVersion=" + this.vmSpecificationVersion + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (this == object) return true;
		if (object == null) return false;

		if (this.getClass() != object.getClass())
			return false;

		final JavaVersion other = (JavaVersion) object;
		return Objects.equals(this.version, other.version)
			&& Objects.equals(this.runtimeVersion, other.runtimeVersion)
			&& Objects.equals(this.specificationVersion, other.specificationVersion)
			&& Objects.equals(this.vmSpecificationVersion, other.vmSpecificationVersion)
			&& Objects.equals(this.vmVersion, other.vmVersion);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.runtimeVersion, this.specificationVersion,
				this.version, this.vmSpecificationVersion, this.vmVersion);
	}


	public String getVersion()
	{
		return this.version;
	}

	public String getVmVersion()
	{
		return this.vmVersion;
	}

	public String getRuntimeVersion()
	{
		return this.runtimeVersion;
	}

	public String getSpecificationVersion()
	{
		return this.specificationVersion;
	}

	public String getVmSpecificationVersion()
	{
		return this.vmSpecificationVersion;
	}
}
