package com.edu.lingnan.demospringboot;

import com.edu.lingnan.demospringboot.dao.SysMenuDao;
import com.edu.lingnan.demospringboot.entity.SystemMenu;
import com.edu.lingnan.demospringboot.service.impl.SysMenuServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoSpringbootApplicationTests {

  @Autowired private SysMenuServiceImpl sysMenuService;

  @Autowired private SysMenuDao sysMenuDao;

  @Test
  void contextLoads() {
    List<SystemMenu> menuList = sysMenuDao.findAll();
    System.out.println(menuList);
  }
}
