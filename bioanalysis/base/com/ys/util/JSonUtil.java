package com.ys.util;

import net.sf.json.JSONObject;

public class JSonUtil {
	/**
	 * 将对象转换为JSON串
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertObj2JsonStr(Object obj) {
		return JSONObject.fromObject(obj).toString();
	}

	/**
	 * 将JSON串转为指定类型的对象
	 * 
	 * @param json
	 * @param tarClass
	 *            目标类型
	 * @return
	 */
	public static <T> T convertJsonStr2Obj(String json, Class<T> tarClass) {
		return tarClass.cast(JSONObject.toBean(JSONObject.fromObject(json), tarClass));
	}
}
