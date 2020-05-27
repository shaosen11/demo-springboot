package com.edu.lingnan.demospringboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 10:44 2020/5/27
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/page/welcome-1").setViewName("page/welcome-1");
        registry.addViewController("/page/welcome-1.html").setViewName("page/welcome-1");
        registry.addViewController("/page/welcome-2.html").setViewName("page/welcome-2");
        registry.addViewController("/page/welcome-3.html").setViewName("page/welcome-3");
    }
}
