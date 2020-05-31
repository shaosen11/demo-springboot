package com.edu.lingnan.demospringboot.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-05-29 20:20:27
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 902998544913696454L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 学号
     */
    @ExcelProperty("学号")
    private String sid;
    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    private String name;
    /**
     * 班级
     */
    @ExcelProperty("班级")
    private String className;
    /**
     * 班级id
     */
    private Integer classId;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String remark;
    /**
     * 1表示可用，0表示删除
     */
    private Integer enable;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

}