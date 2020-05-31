package com.edu.lingnan.demospringboot.entity.commom;

import lombok.Data;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 10:19 2020/5/28
 */
@Data
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private Long count;
    private Object data;
}
