package com.dardan.rrafshi.commons.model;

public enum ByteUnit
{
	BYTE("Byte", "B")
	{
		@Override
		public long toByte(final long value)
		{
			return value;
		}

		@Override
		public long toKilobyte(final long value)
		{
			return value / (D1/D0);
		}

		@Override
		public long toMegabyte(final long value)
		{
			return value / (D2/D0);
		}

		@Override
		public long toGigabyte(final long value)
		{
			return value / (D3/D0);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			return value / (D4/D0);
		}

		@Override
		public long toKibibyte(final long value)
		{
			return value / (B1/B0);
		}

		@Override
		public long toMebibyte(final long value)
		{
			return value / (B2/B0);
		}

		@Override
		public long toGibibyte(final long value)
		{
			return value / (B3/B0);
		}

		@Override
		public long toTebibyte(final long value)
		{
			return value / (B4/B0);
		}
	},

	KILOBYTE("Kilobyte", "kB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (D1/D0), MAX/(D1/D0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			return value;
		}

		@Override
		public long toMegabyte(final long value)
		{
			return value / (D2/D1);
		}

		@Override
		public long toGigabyte(final long value)
		{
			return value / (D3/D1);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			return value / (D4/D1);
		}

		@Override
		public long toKibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B1/B0);
		}

		@Override
		public long toMebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B2/B0);
		}

		@Override
		public long toGibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B3/B0);
		}

		@Override
		public long toTebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B4/B0);
		}
	},

	MEGABYTE("Megabyte", "MB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (D2/D0), MAX/(D2/D0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			return scale(value, (D2/D1), MAX/(D2/D1));
		}

		@Override
		public long toMegabyte(final long value)
		{
			return value;
		}

		@Override
		public long toGigabyte(final long value)
		{
			return value / (D3/D2);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			return value / (D4/D2);
		}

		@Override
		public long toKibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B1/B0);
		}

		@Override
		public long toMebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B2/B0);
		}

		@Override
		public long toGibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B3/B0);
		}

		@Override
		public long toTebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B4/B0);
		}
	},

	GIGABYTE("Gigabyte", "GB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (D3/D0), MAX/(D3/D0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			return scale(value, (D3/D1), MAX/(D3/D1));
		}

		@Override
		public long toMegabyte(final long value)
		{
			return scale(value, (D3/D2), MAX/(D3/D2));
		}

		@Override
		public long toGigabyte(final long value)
		{
			return value;
		}

		@Override
		public long toTerrabyte(final long value)
		{
			return value / (D4/D3);
		}

		@Override
		public long toKibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B1/B0);
		}

		@Override
		public long toMebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B2/B0);
		}

		@Override
		public long toGibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B3/B0);
		}

		@Override
		public long toTebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B4/B0);
		}
	},

	TERRABYTE("Terrabyte", "TB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (D4/D0), MAX/(D4/D0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			return scale(value, (D4/D1), MAX/(D4/D1));
		}

		@Override
		public long toMegabyte(final long value)
		{
			return scale(value, (D4/D2), MAX/(D4/D2));
		}

		@Override
		public long toGigabyte(final long value)
		{
			return scale(value, (D4/D3), MAX/(D4/D3));
		}

		@Override
		public long toTerrabyte(final long value)
		{
			return value;
		}

		@Override
		public long toKibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B1/B0);
		}

		@Override
		public long toMebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B2/B0);
		}

		@Override
		public long toGibibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B3/B0);
		}

		@Override
		public long toTebibyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (B4/B0);
		}
	},

	KIBIBYTE("Kibibyte", "KiB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (B1/B0), MAX/(B1/B0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D1/D0);
		}

		@Override
		public long toMegabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D2/D0);
		}

		@Override
		public long toGigabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D3/D0);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D4/D0);
		}

		@Override
		public long toKibibyte(final long value)
		{
			return value;
		}

		@Override
		public long toMebibyte(final long value)
		{
			return value / (B2/B1);
		}

		@Override
		public long toGibibyte(final long value)
		{
			return value / (B3/B1);
		}

		@Override
		public long toTebibyte(final long value)
		{
			return value / (B4/B1);
		}
	},

	MEBIBYTE("Mebibyte", "MiB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (B2/B0), MAX/(B2/B0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D1/D0);
		}

		@Override
		public long toMegabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D2/D0);
		}

		@Override
		public long toGigabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D3/D0);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D4/D0);
		}

		@Override
		public long toKibibyte(final long value)
		{
			return scale(value, (B2/B1), MAX/(B2/B1));
		}

		@Override
		public long toMebibyte(final long value)
		{
			return value;
		}

		@Override
		public long toGibibyte(final long value)
		{
			return value / (B3/B2);
		}

		@Override
		public long toTebibyte(final long value)
		{
			return value / (B4/B2);
		}
	},

	GIBIBYTE("Gibibyte", "GiB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (B3/B0), MAX/(B3/B0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D1/D0);
		}

		@Override
		public long toMegabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D2/D0);
		}

		@Override
		public long toGigabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D3/D0);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D4/D0);
		}

		@Override
		public long toKibibyte(final long value)
		{
			return scale(value, (B3/B1), MAX/(B3/B1));
		}

		@Override
		public long toMebibyte(final long value)
		{
			return scale(value, (B3/B2), MAX/(B3/B2));
		}

		@Override
		public long toGibibyte(final long value)
		{
			return value;
		}

		@Override
		public long toTebibyte(final long value)
		{
			return value / (B4/B3);
		}
	},

	TEBIBYTE("Tebibyte", "TiB")
	{
		@Override
		public long toByte(final long value)
		{
			return scale(value, (B4/B0), MAX/(B4/B0));
		}

		@Override
		public long toKilobyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D1/D0);
		}

		@Override
		public long toMegabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D2/D0);
		}

		@Override
		public long toGigabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D3/D0);
		}

		@Override
		public long toTerrabyte(final long value)
		{
			final long bytes = this.toByte(value);
			return bytes / (D4/D0);
		}

		@Override
		public long toKibibyte(final long value)
		{
			return scale(value, (B4/B1), MAX/(B4/B1));
		}

		@Override
		public long toMebibyte(final long value)
		{
			return scale(value, (B4/B2), MAX/(B4/B2));
		}

		@Override
		public long toGibibyte(final long value)
		{
			return scale(value, (B4/B3), MAX/(B4/B3));
		}

		@Override
		public long toTebibyte(final long value)
		{
			return value;
		}
	};


	private static final long MAX = Long.MAX_VALUE;

	private static final long D0 = 1L;
	private static final long D1 = D0 * 1000L;
	private static final long D2 = D1 * 1000L;
	private static final long D3 = D2 * 1000L;
	private static final long D4 = D3 * 1000L;

	private static final long B0 = 1L;
	private static final long B1 = B0 * 1024L;
	private static final long B2 = B1 * 1024L;
	private static final long B3 = B2 * 1024L;
	private static final long B4 = B3 * 1024L;


	private static long scale(final long value, final long factor, final long boundary)
	{
		if(value > boundary) return Long.MAX_VALUE;
		if(value < boundary) return Long.MIN_VALUE;
		return value * factor;
	}


	private String name;
	private String abbreviation;


	ByteUnit(final String name, final String abbreviation)
	{
		this.name = name;
		this.abbreviation = abbreviation;
	}


	public abstract long toByte(long value);

	public abstract long toKilobyte(long value);
	public abstract long toMegabyte(long value);
	public abstract long toGigabyte(long value);
	public abstract long toTerrabyte(long value);

	public abstract long toKibibyte(long value);
	public abstract long toMebibyte(long value);
	public abstract long toGibibyte(long value);
	public abstract long toTebibyte(long value);


	public String getName()
	{
		return this.name;
	}

	public String getAbbreviation()
	{
		return this.abbreviation;
	}
}
