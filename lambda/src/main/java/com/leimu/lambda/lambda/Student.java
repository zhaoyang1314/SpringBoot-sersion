package com.leimu.lambda.lambda;

/**
 * @author: wade
 * @Date: 2021/07/30/11:14
 * @qq:1143011510
 * @Description:
 */
public class Student {
    public   int age;
    public  int high;
    public  String name;

    public Student(int age, int high, String name) {
        this.age = age;
        this.high = high;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
