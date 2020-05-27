package com.edu.lingnan.demospringboot.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统菜单表(SystemMenu)实体类
 *
 * @author makejava
 * @since 2020-05-27 17:15:21
 */
@Data
public class SystemMenu implements Serializable {
    private Integer id;
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private String target;
    private Integer sort;
    private Integer status;
    private String remark;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;
}