package com.edu.lingnan.demospringboot.dao;

import com.edu.lingnan.demospringboot.entity.SysMenu;
import com.edu.lingnan.demospringboot.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 17:05 2020/5/27
 */
@Mapper
@Repository
public interface SysMenuDao {
    List<SystemMenu> getAllSystemMenu();

    List<SystemMenu> findAll();
}
