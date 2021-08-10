package com.session2.springsession2.service.impl;

import com.session2.springsession2.mapper.LoginMapper;
import com.session2.springsession2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wade
 * @Date: 2021/07/31/10:28
 * @qq:1143011510
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String loginInfo(String username) {
        String loginInfo = loginMapper.getLoginInfo(username);
        return loginInfo;
    }

    @Override
    public List getUserName(String[] userName) {
        List userAll = loginMapper.getUserAll(userName);
        return userAll;
    }
}
