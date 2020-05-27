package com.edu.lingnan.demospringboot.controller;

import com.edu.lingnan.demospringboot.entity.SysUser;
import com.edu.lingnan.demospringboot.service.SysMenuService;
import com.edu.lingnan.demospringboot.service.SysUserService;
import com.edu.lingnan.demospringboot.service.impl.SysMenuServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-05-27 17:29:30
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuServiceImpl sysMenuService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Integer id) {
        return this.sysUserService.queryById(id);
    }

    @PostMapping("login")
    public String login(String username, String password, HttpSession session){
        SysUser sysUser = sysUserService.login(username, password);
        if (sysUser == null){
            return "login";
        }
        session.setAttribute("sysUser", sysUser);
        return "index";
    }

    @GetMapping("/menu")
    @ResponseBody
    public Map<String, Object> menu() {
        return sysMenuService.menu();
    }
}