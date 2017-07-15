package com.ys.project.dao.imp;

import org.springframework.stereotype.Repository;

import com.ys.project.dao.UserInfoDao;
import com.ys.project.entity.UserInfo;
import com.ys.project.imp.EntityDaoSqlMapImpl;

@Repository("userInfoDao")
public class UserInfoDaoImp extends EntityDaoSqlMapImpl<UserInfo> implements UserInfoDao {

}
