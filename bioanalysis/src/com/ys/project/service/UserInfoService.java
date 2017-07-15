package com.ys.project.service;

import java.util.List;

import com.ys.project.entity.UserInfo;

public interface UserInfoService {
	List<UserInfo> getUserInfoList(UserInfo user);
	
	UserInfo getUserInfo(UserInfo user);
	
	int modifyUserInfo(UserInfo user);
}
