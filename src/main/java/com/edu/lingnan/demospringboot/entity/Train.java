package com.edu.lingnan.demospringboot.entity;

import java.io.Serializable;

/**
 * (Train)实体类
 *
 * @author makejava
 * @since 2020-05-27 17:24:08
 */
public class Train implements Serializable {
    private static final long serialVersionUID = 280035844133395442L;
    /**
    * 自增id
    */
    private Integer id;
    /**
    * 序号
    */
    private Integer serialNumber;
    /**
    * 学号
    */
    private Integer studentId;
    /**
    * 姓名
    */
    private String name;
    /**
    * 班级
    */
    private String className;
    /**
    * 备注
    */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}