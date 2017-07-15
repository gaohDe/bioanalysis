package com.ys.project.action;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import com.ys.base.BaseAction;
import com.ys.project.entity.UserInfo;
import com.ys.util.JSonUtil;

@Controller("loginAction")
public class LoginAction extends BaseAction{
	private String login_name;
	private String password;
	private String is_remember;
	
	private UserInfo user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String checkUser() {
		System.out.println("aaaaaaaaaaaaaaaaaa");
		System.out.println("login_name is " + login_name);
		System.out.println("password is " + password);
		return "success";
		
	}
	
	private static final String DEFAULT_PASSWORD = "......";

	public String execute() {
		return this.showLoginForm();
	}

	public String showLoginForm() {
		return "login";
	}

	public String login() throws Exception {
		String msg = "";
		if(StringUtils.isEmpty(login_name)) {
			return JSonUtil.convertObj2JsonStr("登录用户名不能为空");
		}
		if(StringUtils.isBlank(password)) {
			return JSonUtil.convertObj2JsonStr("用户密码不能为空");
		}

		HttpSession session = request.getSession();
		
		login_name = login_name.trim();
		UserInfo entity = new UserInfo();
		entity.setUser_name(login_name);
		List<UserInfo> userInfoList = getFacade().getUserInfoService().getUserInfoList(entity);
		if (null == userInfoList || userInfoList.size() == 0) {
			msg = "无此用户，请确认用户名是否正确";
			return JSonUtil.convertObj2JsonStr(msg);
		} else if (userInfoList.size() > 1) {
			msg = "用户异常，请联系系统管理员";
			return JSonUtil.convertObj2JsonStr(msg);
		}

		Cookie passwordCookie = WebUtils.getCookie(request, "password");
		if (null != passwordCookie && DEFAULT_PASSWORD.equals(password)) {
			entity.setPassword(passwordCookie.getValue());
		} else {
			entity.setPassword(password.toUpperCase());
		}
		UserInfo userInfo = getFacade().getUserInfoService().getUserInfo(entity);
		if (null == userInfo) {
			msg = "密码错误，请确认密码重新输入";
			return JSonUtil.convertObj2JsonStr(msg);
		} else {
			CookieGenerator cg = new CookieGenerator();
			if (is_remember != null) {
				cg.setCookieMaxAge(60 * 60 * 24 * 14);
				cg.setCookieName("login_name");
				cg.addCookie(response, URLEncoder.encode(login_name, "UTF-8"));
				cg.setCookieName("password");
				cg.addCookie(response, URLEncoder.encode(entity.getPassword(), "UTF-8"));
				cg.setCookieName("is_remember");
				cg.addCookie(response, URLEncoder.encode(is_remember, "UTF-8"));
			} else {
				cg.setCookieMaxAge(0);
				cg.setCookieName("login_name");
				cg.removeCookie(response);
				cg.setCookieName("password");
				cg.removeCookie(response);
				cg.setCookieName("is_remember");
				cg.removeCookie(response);
			}

			if (0l != userInfo.getId() && "1".equals(userInfo.getIs_locked())) {// 0否1是，是否锁定 ,去除管理员用户admin
				msg = "用户已被锁定";
				return JSonUtil.convertObj2JsonStr(msg);
			}

			// update login count
			UserInfo ui = new UserInfo();
			ui.setId(userInfo.getId());
			getFacade().getUserInfoService().modifyUserInfo(ui);

			//session.setAttribute(Keys.SESSION_USERINFO_KEY, userInfo);

			return "success";

		}
	}
/**
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		if (null != session) {
			session.removeAttribute(Keys.SESSION_USERINFO_KEY);
			session.invalidate();
		}
		request.setAttribute("isEnabledCode", super.getSysSetting("isEnabledCode"));
		setCookies2RequestScope(request);
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		int cur_year = now.get(Calendar.YEAR);
		request.setAttribute("cur_year", String.valueOf(cur_year));
		DynaBean dynaBean = (DynaBean) form;
		dynaBean.set("year", String.valueOf(cur_year));
		return mapping.findForward("login");
	}

	private void setCookies2RequestScope(HttpServletRequest request) throws Exception {
		Cookie login_name = WebUtils.getCookie(request, "login_name");
		Cookie password = WebUtils.getCookie(request, "password");
		Cookie is_remember = WebUtils.getCookie(request, "is_remember");

		if (null != login_name) {
			request.setAttribute("login_name", URLDecoder.decode(login_name.getValue(), "UTF-8"));
		}
		if (null != password) {
			request.setAttribute("password", DEFAULT_PASSWORD);
		}
		if (null != is_remember) {
			request.setAttribute("is_remember", URLDecoder.decode(is_remember.getValue(), "UTF-8"));
		}
	}*/

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

	public String getIs_remember() {
		return is_remember;
	}

	public void setIs_remember(String is_remember) {
		this.is_remember = is_remember;
	}
	
}
