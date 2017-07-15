package com.ys.util;

public class StringUtils {
	public static boolean isEmpty(String str) {
		if(null == str || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String trim(String str) {
		if(null == str || "".equals(str)) {
			return "";
		} else {
			return str.trim();
		}
		
	}
}
