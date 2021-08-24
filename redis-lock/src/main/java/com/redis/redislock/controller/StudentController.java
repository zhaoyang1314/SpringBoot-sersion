package com.redis.redislock.controller;

import com.redis.redislock.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wade
 * @Date: 2021/08/24/10:44
 * @qq:1143011510
 * @Description:
 */
@RestController
public class StudentController {

    private static Map<String, Object> studentMap = new HashMap();

    static {
        studentMap.put("stuid",1235);
        studentMap.put("sname","123");
    }

    @Autowired
    private IStudentService iStudentService;

    @RequestMapping("/add")
    @Transactional
    public String addStudent(){
        iStudentService.insertStudent(studentMap);
        if (1>0){
            throw  new RuntimeException("insert 出现异常");
        }
        return "";
    }
}
