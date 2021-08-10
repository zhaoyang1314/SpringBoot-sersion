package com.datasource.aopdatasource.dataConfig;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: wade
 * @Date: 2021/08/07/13:16
 * @qq:1143011510
 * @Description: 动态数据源AOP
 */
@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceSwitchAspect {
    //设置该路径下mapper使用first数据源
    @Pointcut("execution(* com.datasource.aopdatasource.mapper.first..*.*(..))")
    private void firstAspect() {
    }
    //设置该路径下mapper使用second数据源
    @Pointcut("execution(* com.datasource.aopdatasource.mapper.second..*.*(..))")
    private void secondAspect() {
    }

    @Before("firstAspect()")
    public void first() {
        log.info("切换到first数据源...");
        DbContextHolder.setDbType(DBTypeEnum.first);
    }

    @Before("secondAspect()")
    public void second() {
        log.info("切换到second数据源...");
        DbContextHolder.setDbType(DBTypeEnum.second);
    }
}
