package com.edu.lingnan.demospringboot.controller;

import com.edu.lingnan.demospringboot.bean.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** @Author shaosen @Description //TODO @Date 11:02 2020/5/25 */
@Controller
public class HelloController {
  @Value("${neu.classname}")
  private String name;

  @Value("${neu.count}")
  private Integer count;

  @Autowired
  private person person;

  @RequestMapping("hello")
  @ResponseBody
  public String hello() {
    return "name:" + name + ",count:" + count + "person:" + person + ",hello spring boot";
  }

}
