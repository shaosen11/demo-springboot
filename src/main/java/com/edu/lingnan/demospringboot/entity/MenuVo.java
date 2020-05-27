package com.edu.lingnan.demospringboot.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:53 2020/5/27
 */
@Data
public class MenuVo {
    private Integer id;

    private Integer pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private List<MenuVo> child;
}
