package com.mall.dao.impl;

import com.mall.dao.UserDao;
import com.mall.entity.UserInfo;
import com.mall.mappers.UserInfoMapper;
import com.mall.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CacheConfig(cacheNames = "UserCache")
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void insertUserInfo(UserInfo userinfo) {
        userInfoMapper.insertUserInfo(userinfo);
    }

    @Override
    @Cacheable(value = "UserCache",key = "'userinfo'+#userinfo.id")
    public UserInfo findUserById(UserInfo userinfo) {
        System.out.println("本地缓存无数据，查数据库返回");
        return userInfoMapper.findUserById(userinfo);
    }

    @Override
    @CachePut(value = "UserCache",key = "'userinfo'+#userinfo.id")
    public UserInfo updateUserById(UserInfo userinfo) {
        userInfoMapper.updateUserById(userinfo);
        return userInfoMapper.findUserById(userinfo);
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
