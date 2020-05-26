package com.edu.lingnan.demospringboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:25 2020/5/25
 */
@Data
@ConfigurationProperties("neu.person")
@Component
public class person {
    private String name;
    private int age;
}
