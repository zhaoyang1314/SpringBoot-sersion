package com.datasource.aopdatasource.dataConfig;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.*;

/**
 * @author: wade
 * @Date: 2021/08/10/14:47
 * @qq:1143011510
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSources {
    // 枚举
    DBTypeEnum value();
}
