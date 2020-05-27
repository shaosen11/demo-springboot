package com.edu.lingnan.demospringboot.controller;

import com.edu.lingnan.demospringboot.entity.Train;
import com.edu.lingnan.demospringboot.service.IImportExcelService;
import com.edu.lingnan.demospringboot.service.TrainService;
import com.edu.lingnan.demospringboot.service.impl.IImportExcelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (Train)表控制层
 *
 * @author makejava
 * @since 2020-05-26 20:50:25
 */
@Controller
@RequestMapping("train")
public class TrainController {
    /**
     * 服务对象
     */
    @Resource
    private TrainService trainService;

    @Resource
    private IImportExcelServiceImpl iImportExcelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Train selectOne(Integer id) {
        return this.trainService.queryById(id);
    }

    @PostMapping("/files")
    public String withSimple(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
        List<Train> list = iImportExcelService.importExcelWithSimple(file, req, resp);
        if(list == null || list.size() == 0 ) {
            return "fail";
        }
        for(Train bean:list) {
            System.out.println(bean.toString());
            //批量插入list到数据库
            trainService.insert(bean);
        }
        return "success";
    }

    @RequestMapping("/fileinput")
    public String fileView(){
        return "fileinput";
    }
}