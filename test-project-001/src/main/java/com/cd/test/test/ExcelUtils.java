package com.cd.test.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/5.
 */
public class ExcelUtils {
    public static void main(String[] args) {
        List list = new ArrayList();
        exportExcel(list);
    }

    public static void exportExcel(List<Map> list) {
        Workbook wb = new HSSFWorkbook();

        for (int i = 0; i < list.size(); i++) {

        }

        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short) 0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        Sheet sheet2 = wb.createSheet("second sheet");

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\excel.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

