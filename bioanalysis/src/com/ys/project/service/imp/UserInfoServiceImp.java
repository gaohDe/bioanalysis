package com.ys.project.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ys.project.dao.UserInfoDao;
import com.ys.project.entity.UserInfo;
import com.ys.project.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImp implements UserInfoService{
	UserInfoDao userInfoDao;
	
	public List<UserInfo> getUserInfoList(UserInfo user) {
		return userInfoDao.selectEntityList(user);
	}

	public UserInfo getUserInfo(UserInfo user) {
		return userInfoDao.selectEntity(user);
	}

	public int modifyUserInfo(UserInfo user) {
		return userInfoDao.updateEntity(user);
	}

}
