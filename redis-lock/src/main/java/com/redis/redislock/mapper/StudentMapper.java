package com.redis.redislock.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author: wade
 * @Date: 2021/08/23/16:37
 * @qq:1143011510
 * @Description:
 */
@Mapper
public interface StudentMapper {
    /**
     * @param infoMap
     * @return
     * @Description: 进行新增数据操作
     */
  public void insertStudentInfo(Map<String, Object> infoMap);
}
