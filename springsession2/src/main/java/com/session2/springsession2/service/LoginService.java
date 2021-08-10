package com.session2.springsession2.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wade
 * @Date: 2021/07/31/10:26
 * @qq:1143011510
 * @Description:
 */
public interface LoginService {
    public  String loginInfo(String username);

    public  List getUserName(String[] userName);
}
