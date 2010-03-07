package nu.milsson.fullambda;

class Utils {
	static Object defaultValueFor(Class<?> clazz) {
		if (!clazz.isPrimitive())
			return null;
		else if (clazz == byte.class)
			return Byte.valueOf((byte) 0);
		else if (clazz == short.class)
			return Short.valueOf((short) 0);
		else if (clazz == int.class)
			return Integer.valueOf((int) 0);
		else if (clazz == long.class)
			return Long.valueOf((long) 0L);
		else if (clazz == float.class)
			return Float.valueOf((float) 0.0f);
		else if (clazz == double.class)
			return Double.valueOf((double) 0.0d);
		else if (clazz == char.class)
			return Character.valueOf((char) '\u0000');
		else if (clazz == boolean.class)
			return Boolean.valueOf((boolean) false);
		else
			throw new IllegalArgumentException();
	}
}
