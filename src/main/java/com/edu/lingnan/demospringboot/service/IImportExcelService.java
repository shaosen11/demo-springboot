package com.edu.lingnan.demospringboot.service;

import com.edu.lingnan.demospringboot.entity.Train;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 19:41 2020/5/26
 */
public interface IImportExcelService {

    /**
     * 获取导入的Excel表中数据
     * @return 返回集合
     */
    public List<Train> importExcelWithSimple(MultipartFile file,HttpServletRequest req,HttpServletResponse resp);
}
