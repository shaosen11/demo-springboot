package com.edu.lingnan.demospringboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 17:01 2020/5/27
 */
@Data
public class SysMenu implements Serializable {
    private MenuKey key;
    private Long pid;
    private String icon;
    private String target;
    private Integer sort;
    private Boolean status;
    private String remark;
    private Date create_at;
    private Date update_at;
    private Date delete_at;
}
