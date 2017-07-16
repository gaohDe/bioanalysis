package com.ys.project.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ys.project.service.Facade;
import com.ys.project.service.UserInfoService;
@Component("facade")
public class FacadeImpl implements Facade {
	@Autowired
	@Qualifier("userInfoService")
	private UserInfoService userInfoService;
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

}
