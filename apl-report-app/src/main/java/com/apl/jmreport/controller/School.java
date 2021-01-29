package com.apl.jmreport.controller;

import java.io.Serializable;

/**
 * @author hjr start
 * @Classname School
 * @Date 2021/1/22 17:49
 */
public class School implements Serializable {

    private String schoolName;

    private String mechanicalProperty;

    private String type;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMechanicalProperty() {
        return mechanicalProperty;
    }

    public void setMechanicalProperty(String mechanicalProperty) {
        this.mechanicalProperty = mechanicalProperty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
