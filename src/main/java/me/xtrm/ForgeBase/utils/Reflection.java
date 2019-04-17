package me.xtrm.ForgeBase.utils;

import java.lang.reflect.Field;

public class Reflection {
	
	public static Object getFieldValue(Object obj, String field) {
		try {
			Field f = obj.getClass().getDeclaredField(field);
			f.setAccessible(true);
			return f.get(obj);
		} catch(SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
