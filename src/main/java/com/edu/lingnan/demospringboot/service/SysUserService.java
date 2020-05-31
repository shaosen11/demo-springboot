package com.edu.lingnan.demospringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.lingnan.demospringboot.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 17:29:29
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 分页查询
     *
     * @param sysUser
     * @param page
     * @param pageSize
     * @return
     */
    IPage<SysUser> selectPageExt(SysUser sysUser, Integer page, Integer pageSize);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    boolean update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    SysUser login(String username, String password);

    boolean delete(List<Integer> ids);
}