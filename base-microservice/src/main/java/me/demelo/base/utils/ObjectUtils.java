package me.demelo.base.utils;

public class ObjectUtils {

	public static <T> T defaultIfNull(T value, T defaultValue) {
		if (value == null)
			return defaultValue;
		return value;
	}
}
