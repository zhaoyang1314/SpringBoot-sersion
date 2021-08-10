package com.datasource.aopdatasource.dataConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: wade
 * @Date: 2021/08/07/13:18
 * @qq:1143011510
 * @Description: 动态转换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
