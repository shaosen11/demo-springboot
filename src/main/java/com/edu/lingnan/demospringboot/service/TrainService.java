package com.edu.lingnan.demospringboot.service;

import com.edu.lingnan.demospringboot.entity.Train;
import java.util.List;

/**
 * (Train)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 17:24:09
 */
public interface TrainService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Train queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Train> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param train 实例对象
     * @return 实例对象
     */
    Train insert(Train train);

    /**
     * 修改数据
     *
     * @param train 实例对象
     * @return 实例对象
     */
    Train update(Train train);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}