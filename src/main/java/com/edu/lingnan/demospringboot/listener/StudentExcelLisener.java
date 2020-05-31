package com.edu.lingnan.demospringboot.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.edu.lingnan.demospringboot.entity.Student;
import com.edu.lingnan.demospringboot.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 20:52 2020/5/29
 */
public class StudentExcelLisener extends AnalysisEventListener<Student> {

    private List<Student> data = new ArrayList<>();

    private StudentService studentService;

    public StudentExcelLisener(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        //解析数据保存到studentExcel
        data.add(student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当Excel解析完毕后，执行
        System.out.println(data);
        if (studentService != null) {
            studentService.insert(data);
        }
    }
}
