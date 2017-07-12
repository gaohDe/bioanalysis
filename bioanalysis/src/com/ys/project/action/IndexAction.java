package com.ys.project.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.ys.base.BaseAction;
import com.ys.project.entity.User;

@Controller("indexAction")
public class IndexAction extends BaseAction {
	private Map<String, Object> dataMap;
	private String key = "Just see see";  
	
	public String execute() {
		dataMap = new HashMap<String, Object>();  
        User user = new User();  
        user.setName("张三");  
        user.setId(123);  
        dataMap.put("user", user);  
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
