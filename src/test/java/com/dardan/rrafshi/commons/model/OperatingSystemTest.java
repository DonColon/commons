package com.dardan.rrafshi.commons.model;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.commons.contracts.EqualsContract;
import com.dardan.rrafshi.commons.contracts.HashcodeContract;


public final class OperatingSystemTest implements EqualsContract<OperatingSystem>, HashcodeContract<OperatingSystem>
{
	@Override
	public OperatingSystem createValue()
	{
		return Systems.getOperatingSystem();
	}

	@Override
	public OperatingSystem createNotEqualValue()
	{
		return new OperatingSystem("1in", "9", "x32", 4);
	}
}
