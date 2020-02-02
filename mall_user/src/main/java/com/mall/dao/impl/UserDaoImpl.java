package com.mall.dao.impl;

import com.mall.dao.UserDao;
import com.mall.entity.UserInfo;
import com.mall.mappers.UserInfoMapper;
import com.mall.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void insertUserInfo(UserInfo userinfo) {
        userInfoMapper.insertUserInfo(userinfo);
    }

    @Override
    public UserInfo findUserById(UserInfo userinfo) {
        return userInfoMapper.findUserById(userinfo);
    }

    @Override
    public void updateUserById(UserInfo userinfo) {
        userInfoMapper.updateUserById(userinfo);
    }

    @Override
    public List<UserInfo> findUserInfoByVo(UserInfoVo userInfoVo) {
        return userInfoMapper.findUserInfoByVo(userInfoVo);
    }

    @Override
    public UserInfo findByUsername(UserInfo userinfo) {
        return userInfoMapper.findByUsername(userinfo);
    }


}
