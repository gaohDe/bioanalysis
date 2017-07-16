package com.ys.project.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import com.ys.base.BaseAction;
import com.ys.project.entity.UserInfo;

@Controller("loginAction")
public class LoginAction extends BaseAction{
	private String login_name;
	private String password;
	private String key = "Just see see"; 
	
	private UserInfo user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_PASSWORD = "......";

	public String login() {
		String msg = "执行成功";
		user = new UserInfo();
		
		if(StringUtils.isEmpty(login_name)) {
			msg = "登录用户名不能为空";
			sendJson("1",msg,null);
			return "success";
		}
		if(StringUtils.isBlank(password)) {
			msg = "登录密码不能为空";
			sendJson("1",msg,null);
			return "success";
		}

		HttpSession session = request.getSession();
		
		login_name = login_name.trim();
		UserInfo entity = new UserInfo();
		entity.setUser_name(login_name);
		List<UserInfo> userInfoList = getFacade().getUserInfoService().getUserInfoList(entity);
		if (null == userInfoList || userInfoList.size() == 0) {
			msg = "无此用户，请确认用户名是否正确";
			sendJson("1",msg,null);
			return "success";
		} else if (userInfoList.size() > 1) {
			msg = "用户异常，请联系系统管理员";
			sendJson("1",msg,null);
			return "success";
		}

		Cookie passwordCookie = WebUtils.getCookie(request, "password");
		if (null != passwordCookie && DEFAULT_PASSWORD.equals(password)) {
			entity.setPassword(passwordCookie.getValue());
		} else {
			entity.setPassword(password);
		}
		UserInfo userInfo = getFacade().getUserInfoService().getUserInfo(entity);
		if (null == userInfo) {
			msg = "密码错误，请确认密码重新输入";
			sendJson("1",msg,null);
			return "success";
		} else {
			CookieGenerator cg = new CookieGenerator();
			cg.setCookieMaxAge(0);
			cg.setCookieName("login_name");
			cg.removeCookie(response);
			cg.setCookieName("password");
			cg.removeCookie(response);
			cg.setCookieName("is_remember");
			cg.removeCookie(response);

			if (0l != userInfo.getId() && "1".equals(userInfo.getIs_locked())) {// 0否1是，是否锁定 ,去除管理员用户admin
				msg = "用户已被锁定";
				sendJson("1",msg,null);
				return "success";
			}

			session.setAttribute("userInfo", userInfo);
			sendJson("0",msg,userInfo);
			return "success";

		}
	}

	@JSON
	public String getLogin_name() {
		return login_name;
	}

	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	@JSON
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
