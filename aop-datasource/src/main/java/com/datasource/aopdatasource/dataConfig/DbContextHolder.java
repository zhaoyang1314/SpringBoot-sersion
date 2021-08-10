package com.datasource.aopdatasource.dataConfig;

/**
 * @author: wade
 * @Date: 2021/08/07/13:14
 * @qq:1143011510
 * @Description: 动态数据源 DbContextHolder
 */
public class DbContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return (String) contextHolder.get();
    }
}
