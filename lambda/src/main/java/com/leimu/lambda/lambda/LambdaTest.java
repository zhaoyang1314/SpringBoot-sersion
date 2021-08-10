package com.leimu.lambda.lambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author: wade
 * @Date: 2021/07/30/9:16
 * @qq:1143011510
 * @Description:
 */
public class LambdaTest {

    private static LambdaConfig lambdaConfig = new LambdaConfig();

    public static void  test1(){
        String str = "f";
        String[] zu = {"l","m"};
        lambdaConfig.setRemarks(zu);
       final boolean anyMatch = Optional.ofNullable(str).map(i ->
                Arrays.stream(lambdaConfig.getRemarks())
                        .anyMatch(ad -> ("*".equals(ad) || i.startsWith(ad))))
                        .orElse(false);
        System.out.println(anyMatch);
    }

    public static void main(String[] args) {
        test1();
    }
}
