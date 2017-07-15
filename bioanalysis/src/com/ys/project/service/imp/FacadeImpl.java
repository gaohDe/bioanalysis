package com.ys.project.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.ys.project.service.Facade;
import com.ys.project.service.UserInfoService;

public class FacadeImpl implements Facade {
	@Autowired
	private UserInfoService userInfoService;
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

}
