package com.edu.lingnan.demospringboot.dao;

import com.edu.lingnan.demospringboot.entity.Train;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Train)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 17:24:08
 */
@Mapper
@Repository
public interface TrainDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Train queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Train> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param train 实例对象
     * @return 对象列表
     */
    List<Train> queryAll(Train train);

    /**
     * 新增数据
     *
     * @param train 实例对象
     * @return 影响行数
     */
    int insert(Train train);

    /**
     * 修改数据
     *
     * @param train 实例对象
     * @return 影响行数
     */
    int update(Train train);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}