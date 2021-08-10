package com.datasource.aopdatasource.dataConfig;

/**
 * @author: wade
 * @Date: 2021/08/07/13:14
 * @qq:1143011510
 * @Description:
 */
public enum DBTypeEnum {
    first("first"), second("second");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
