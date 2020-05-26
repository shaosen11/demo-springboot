package com.edu.lingnan.demospringboot.service.impl;

import com.edu.lingnan.demospringboot.entity.Train;
import com.edu.lingnan.demospringboot.service.IImportExcelService;
import com.edu.lingnan.demospringboot.service.ImportExcelBaseService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** @Author shaosen @Description //TODO @Date 19:42 2020/5/26 */
@Service
public class IImportExcelServiceImpl extends ImportExcelBaseService implements IImportExcelService {
  @Override
  public List<Train> importExcelWithSimple(MultipartFile file,HttpServletRequest req,HttpServletResponse resp) {
//    File file = new File("C:\\Users\\12447\\Desktop\\17外包第6学期实训安排(4).xlsx");
    if (file.isEmpty()) {
      System.out.println("文件为空！");
    }



    // 得到工作空间
    Workbook workbook = null;
    try {
      workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
    } catch (IOException e) {
      e.printStackTrace();
    }
    List<Train> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < 3 ; i++ ){
      // 得到工作表
      Sheet sheet = super.getSheetByWorkbook(workbook, i);
      int rowNum = 0; // 已取值的行数
      int colNum = 0; // 列号
      int realRowCount = 0; // 真正有数据的行数
      if (sheet.getRow(2000) != null) {
        throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
      }

      realRowCount = sheet.getPhysicalNumberOfRows();

      Train Train = null;

      for (Row row : sheet) {
        if (realRowCount == rowNum) {
          break;
        }

        if (super.isBlankRow(row)) { // 空行跳过
          continue;
        }

        if (row.getRowNum() == -1) {
          continue;
        } else {
          if (row.getRowNum() == 0  || row.getRowNum() == 1) { // 第一行表头跳过
            continue;
          }
        }
        count++;
        rowNum++;
        colNum = 0;
        Train = new Train();

        super.validCellValue(sheet, row, ++colNum, "序号");
        Train.setSerialNumber(Integer.valueOf(super.getCellValue(sheet, row, colNum - 1)));

        super.validCellValue(sheet, row, ++colNum, "学号");
        Train.setStudentId(Integer.valueOf(super.getCellValue(sheet, row, colNum - 1)));

        super.validCellValue(sheet, row, ++colNum, "姓名");
        Train.setName(super.getCellValue(sheet, row, colNum - 1));

        super.validCellValue(sheet, row, ++colNum, "班级");
        Train.setClassName(super.getCellValue(sheet, row, colNum - 1));

        super.validCellValue(sheet, row, ++colNum, "备注");
        Train.setRemark(super.getCellValue(sheet, row, colNum - 1));

        list.add(Train);
      }
//      for (Train train : list) {
//        System.out.println(train);
//      }
//      System.out.println(count);
//      System.out.println();
    }
    return list;
  }
}
