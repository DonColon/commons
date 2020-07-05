package com.dardan.rrafshi.commons.model;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.commons.contracts.EqualsContract;
import com.dardan.rrafshi.commons.contracts.HashcodeContract;


public final class JavaVersionTest implements EqualsContract<JavaVersion>, HashcodeContract<JavaVersion>
{
	@Override
	public JavaVersion createValue()
	{
		return Systems.getJavaVersion();
	}

	@Override
	public JavaVersion createNotEqualValue()
	{
		return new JavaVersion("1.7", "1.7", "1.7", "1.7", "1.7");
	}
}
