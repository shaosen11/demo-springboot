package com.edu.lingnan.demospringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-05-27 17:29:26
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -20484358126689417L;

    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 组织id
     */
    private Integer orgId;
    /**
     * 0无效用户，1是有效用户
     */
    private Integer enabled;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;


}