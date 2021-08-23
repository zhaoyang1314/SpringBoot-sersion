package com.redis.redislock.redis.snowConfig;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wade
 * @Date: 2021/08/12/22:21
 * @qq:1143011510
 * @Description:
 */
@Configuration
public class SnowflakeConfig {
    @Value("${application.datacenterId}")
    private Long datacenterId;

    @Value("${application.workerId}")
    private Long workerId;

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(workerId, datacenterId);
    }
}
