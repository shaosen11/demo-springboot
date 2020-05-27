package com.edu.lingnan.demospringboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:51 2020/5/27
 */
@Data
public class MenuKey implements Serializable {
    private Long id;
    private String title;
    private String href;
}
