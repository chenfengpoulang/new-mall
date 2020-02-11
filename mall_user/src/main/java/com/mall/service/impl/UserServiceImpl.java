package com.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mall.dao.UserDao;
import com.mall.entity.UserInfo;
import com.mall.service.UserService;
import com.mall.utils.Md5Util;
import com.mall.vo.ConstomUserInfo;
import com.mall.vo.UserInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUserInfo(UserInfo userinfo) {
        String passwd = userinfo.getPasswordplaintext();
        try {
            passwd = Md5Util.MD5(passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userinfo.setPasswordencrypt(passwd);
        userDao.insertUserInfo(userinfo);
    }

    @Override
    public UserInfo findUserById(Long id) {
        UserInfo userinfo = new UserInfo();
        userinfo.setId(id);
        return userDao.findUserById(userinfo);
    }

    @Override
    public UserInfo updateUserById(UserInfo userinfo) {
        return userDao.updateUserById(userinfo);
    }

    @Override
    public List<UserInfo> findUserInfoByVo(ConstomUserInfo constomUserInfo) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setConstomUserInfo(constomUserInfo);
        return userDao.findUserInfoByVo(userInfoVo);
    }

    @Override
    public Map<String,String> validLogin(String account, String passw) {
        Map<String,String> resultmap = new HashMap<String,String>();
        resultmap.put("message","");
        resultmap.put("result","true");
        UserInfo userInfo = new UserInfo();
        if(StringUtils.isBlank(account)||StringUtils.isBlank(passw)){
            resultmap.put("message","用户名或者密码为空");
            resultmap.put("result","false");
            return resultmap;
        }
        userInfo.setAccount(account);
        UserInfo userInfo1 = userDao.findByUsername(userInfo);
        if(userInfo1 == null){
            resultmap.put("message","不存在该用户");
            resultmap.put("result","false");
        }else{
            try {
                String passwordencrypt =  userInfo1.getPasswordencrypt();
                String md5passw =  Md5Util.MD5(passw);
                if(!passwordencrypt.equals(md5passw)){
                    resultmap.put("message","密码不对");
                    resultmap.put("result","false");
                }else{
                    userInfo = userInfo1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String userInfoString = JSONObject.toJSONString(userInfo);
        resultmap.put("userInfo",userInfoString);
        return resultmap;
    }
}
