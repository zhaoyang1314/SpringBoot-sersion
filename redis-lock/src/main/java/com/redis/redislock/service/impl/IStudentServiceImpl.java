package com.redis.redislock.service.impl;

import com.redis.redislock.mapper.StudentMapper;
import com.redis.redislock.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author: wade
 * @Date: 2021/08/23/16:35
 * @qq:1143011510
 * @Description:
 */
@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 插入数据
     * @param infoMap
     */
    @Override
    public void insertStudent(Map<String, Object> infoMap) {
        studentMapper.insertStudentInfo(infoMap);

    }
}
