package com.ys.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ys.project.service.Facade;

@Component
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private Map<String,Object> dataMap;
	@Autowired
	private Facade facade;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Logger logger = Logger.getLogger(getClass() + "Action");

	protected Facade getFacade() {
		return this.facade;
	}
	
	// 解析请求的Json数据
	public String getRequestPostData(HttpServletRequest request)
			throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {
			int len = request.getInputStream().read(buffer, i,
					contentLength - i);
			if (len == -1) {
				break;
			}
			i += len;
		}
		return new String(buffer, "utf-8");
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		response.setHeader("Access-Control-Allow-Origin", "*"); 
	}
	
	public void sendJson(String retcode, String retMsg, Object obj) {
		dataMap = new HashMap<String, Object>();
		dataMap.put("retcode", retcode);
		dataMap.put("retmsg", retMsg);
		dataMap.put("object", obj);
	}
	
	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }
}
