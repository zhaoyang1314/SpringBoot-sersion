package com.session2.springsession2.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wade
 * @Date: 2021/07/31/10:08
 * @qq:1143011510
 * @Description:
 */
public interface LoginMapper {
   public String getLoginInfo(@Param("username") String username);

   public List getUserAll( String[] username);
}
