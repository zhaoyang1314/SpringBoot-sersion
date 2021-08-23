package com.redis.redislock.controller;

import cn.hutool.core.util.IdUtil;
import com.redis.redislock.redis.util.RedisUtil;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wade
 * @Date: 2021/08/23/14:42
 * @qq:1143011510
 * @Description:
 */
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;
    private  static String redis_key = "redis_util";
    static{
        redis_key = IdUtil.randomUUID();
    }


    @RequestMapping("/exprie")
    public  String exprie(){
        boolean expire = redisUtil.expire(redis_key, 20);
        if (!expire){
            return "error";
        }
        return "success";
    }
    @RequestMapping("/insertKey")
    public String insertKey(){
        boolean b = redisUtil.hasKey(redis_key);
        if(!b){
            boolean redis_util = redisUtil.set("redis_util", redis_key, 20);
            if (redis_util){
                return "success";
            }
        }
        return "";
    }
}
