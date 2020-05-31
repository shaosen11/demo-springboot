package com.edu.lingnan.demospringboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.lingnan.demospringboot.entity.Student;
import com.edu.lingnan.demospringboot.entity.commom.CommonResult;
import com.edu.lingnan.demospringboot.listener.StudentExcelLisener;
import com.edu.lingnan.demospringboot.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-05-29 20:20:31
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

    @PostMapping("findAllStudent")
    @ResponseBody
    public Object findAllStudent(Student student, Integer page, Integer limit) {
        CommonResult<Student> result = new CommonResult<>();
        IPage<Student> iPage = studentService.selectPageExt(student, page, limit);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        try {
            // 读取部分sheet
            ExcelReader excelReader = EasyExcel.read(file.getInputStream()).build();
            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(Student.class).registerReadListener(new StudentExcelLisener(studentService)).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(Student.class).registerReadListener(new StudentExcelLisener(studentService)).build();
            ReadSheet readSheet3 =
                    EasyExcel.readSheet(2).head(Student.class).registerReadListener(new StudentExcelLisener(studentService)).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2, readSheet3);
            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            excelReader.finish();
        } catch (IOException e) {
            result.setMsg("Excel上传出错");
        }
        result.setData(file.getOriginalFilename());
        return result;

//        CommonResult<String> result = new CommonResult<>();
//        try {
//            EasyExcel.read(file.getInputStream(), Student.class, new StudentExcelLisener(studentService)).sheet().doRead();
//        } catch (IOException e) {
//            e.printStackTrace();
//            result.setMsg("Excel上传出错");
//        }
//        result.setData(file.getOriginalFilename());
//        return result;
    }
}