package com.ys.project.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.ys.base.BaseAction;
import com.ys.project.entity.UserInfo;

@Controller("indexAction")
public class IndexAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -289948118473272884L;
	private Map<String, Object> dataMap;
	private String key = "Just see see";  
	
	public String index() {
		dataMap = new HashMap<String, Object>();  
        UserInfo user = new UserInfo();  
        user.setUser_name("张三");  
        user.setId(123);  
        dataMap.put("user", user);  
        System.out.println("aaaaaaaaaaaaaaaaaa");
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true); 
		return "success";
	}
	
	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
	
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
