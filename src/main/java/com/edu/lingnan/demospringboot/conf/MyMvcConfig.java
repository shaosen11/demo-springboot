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
        registry.addViewController("/page/welcome-3.html").setViewName("page/welcome-2");
        registry.addViewController("/page/menu.html").setViewName("page/menu");
        registry.addViewController("/page/setting.html").setViewName("page/setting");
        registry.addViewController("/page/table.html").setViewName("page/table");
        registry.addViewController("/page/student_table.html").setViewName("page/student_table");
        registry.addViewController("/page/form.html").setViewName("page/form");
        registry.addViewController("/page/form-step.html").setViewName("page/form-step");
        registry.addViewController("/page/login-1.html").setViewName("page/login-1");
        registry.addViewController("/page/login-2.html").setViewName("page/login-2");
        registry.addViewController("/page/404.html").setViewName("page/404");
        registry.addViewController("/page/button.html").setViewName("page/button");
        registry.addViewController("/page/layer.html").setViewName("page/layer");
        registry.addViewController("/page/icon.html").setViewName("page/icon");
        registry.addViewController("/page/icon-picker.html").setViewName("page/icon-picker");
        registry.addViewController("/page/color-select.html").setViewName("page/color-select");
        registry.addViewController("/page/table-select.html").setViewName("page/table-select");
        registry.addViewController("/page/upload.html").setViewName("page/upload");
        registry.addViewController("/page/editor.html").setViewName("page/editor");
        registry.addViewController("/page/area.html").setViewName("page/area");
        registry.addViewController("/page/table/add.html").setViewName("/page/table/add");
        registry.addViewController("/page/table/edit.html").setViewName("/page/table/edit");
    }
}
