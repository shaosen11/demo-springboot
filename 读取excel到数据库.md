### 读取excel到数据库

* 读取excel
  * 使用组件

```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>4.1.0</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>4.1.0</version>
</dependency>
```

读取excel

```java
Workbook workbook = null;
    try {
      workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
    } catch (IOException e) {
      e.printStackTrace();
    }
```

读取工作表

```java
for (int i = 0; i < 3; i++) {
    // 得到工作表
    Sheet sheet = super.getSheetByWorkbook(workbook, i);
    // 已取值的行数
    int rowNum = 0;
    // 列号
    int colNum = 0;
    // 真正有数据的行数
    int realRowCount = 0;

    realRowCount = sheet.getPhysicalNumberOfRows();

    Train Train = null;
    for (Row row : sheet) {
        if (realRowCount == rowNum) {
            break;
        }
        // 空行跳过
        if (super.isBlankRow(row)) {
            continue;
        }
        if (row.getRowNum() == -1) {
            continue;
        } else {
            // 第一行表头跳过
            if (row.getRowNum() == 0 || row.getRowNum() == 1) { 
                continue;
            }
        }
        rowNum++;
        colNum = 0;

        //封装对象

        list.add(Train);
    }
}
```

* 封装对象

```java
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
```



* 插入数据库

```java
 trainService.insert(bean);
```

