package com.ys.project.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ys.project.dao.UserInfoDao;
import com.ys.project.entity.UserInfo;
import com.ys.project.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImp implements UserInfoService{
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;
	
	public List<UserInfo> getUserInfoList(UserInfo user) {
		System.out.println("====================================================");
		System.out.println("====================================================");
		return userInfoDao.selectEntityList(user);
	}

	public UserInfo getUserInfo(UserInfo user) {
		return userInfoDao.selectEntity(user);
	}

	public int modifyUserInfo(UserInfo user) {
		return userInfoDao.updateEntity(user);
	}

}
