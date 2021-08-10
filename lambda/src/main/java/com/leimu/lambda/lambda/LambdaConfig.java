package com.leimu.lambda.lambda;

import org.springframework.context.annotation.Configuration;

/**
 * @author: wade
 * @Date: 2021/07/30/9:45
 * @qq:1143011510
 * @Description:
 */

@Configuration
public class LambdaConfig {
    private  String[] remarks;

    public String[] getRemarks() {
        return remarks;
    }

    public void setRemarks(String[] remarks) {
        this.remarks = remarks;
    }
}
