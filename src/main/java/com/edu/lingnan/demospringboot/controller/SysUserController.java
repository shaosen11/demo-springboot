package com.edu.lingnan.demospringboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.lingnan.demospringboot.entity.SysUser;
import com.edu.lingnan.demospringboot.entity.commom.CommonResult;
import com.edu.lingnan.demospringboot.service.SysUserService;
import com.edu.lingnan.demospringboot.service.impl.SysMenuServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
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
    public String login(String username, String password, HttpSession session) {
        SysUser sysUser = sysUserService.login(username, password);
        if (sysUser == null) {
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

    @PostMapping("/findAllUser")
    @ResponseBody
    public Object findAllUser(SysUser sysUser, Integer page, Integer limit) {
        CommonResult<SysUser> result = new CommonResult<>();
        IPage<SysUser> iPage = sysUserService.selectPageExt(sysUser, page, limit);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @PostMapping("/add")
    @ResponseBody
    public SysUser add(SysUser sysUser) {
        System.out.println(sysUser);
        sysUser.setCreateTime(new Date());
        return sysUserService.insert(sysUser);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        sysUserService.delete(Arrays.asList(ids));
        return true;
    }

    @GetMapping("/toEdit")
    public String toEdit(Integer id, Model model) {
        SysUser sysUser = sysUserService.queryById(id);
        model.addAttribute("sysUser", sysUser);
        return "/page/table/edit.html";
    }

    @PutMapping("/edit")
    @ResponseBody
    public boolean edit(SysUser sysUser) {
        System.out.println(sysUser);
        return sysUserService.update(sysUser);
    }
}