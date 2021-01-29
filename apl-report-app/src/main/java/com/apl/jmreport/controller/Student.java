package com.apl.jmreport.controller;

import java.io.Serializable;

/**
 * @author hjr start
 * @Classname Student
 * @Date 2021/1/22 16:04
 */
public class Student implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
