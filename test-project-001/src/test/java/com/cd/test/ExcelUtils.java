package java.com.cd.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/5.
 */
public class ExcelUtils {
    static Workbook wb = new HSSFWorkbook();

    public static void main(String[] args) {
//        List list = new ArrayList();
//        List columns = new ArrayList();
//        exportExcel(list, columns);

        readExcel();
    }

    /**
     * org.apache.poi
     *
     * @param list
     * @param column
     */
    public static void exportExcel(List<Map> list, List column) {
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        int columns = column.size();
        // Create a row and put some cells in it. Rows are 0 based.
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow((short) i);
            for (int j = 0; j < columns; j++) {

                row.createCell(0).setCellValue("");
            }

        }
        // Create a cell and put a value in it.
//        Cell cell = row.createCell(0);
//        row.createCell(1).setCellValue(1.2);
//        row.createCell(2).setCellValue(
//                createHelper.createRichTextString("This is a string"));
//        row.createCell(3).setCellValue(true);
//        Sheet sheet2 = wb.createSheet("second sheet");

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\excel.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * poi read
     */
    public static void readExcel() {
        final int MY_MINIMUM_COLUMN_COUNT = 1;

        // XSSFWorkbook, File
        try (OPCPackage pkg = OPCPackage.open(new File("D:\\task\\task.xlsx"));
             XSSFWorkbook wb = new XSSFWorkbook(pkg)) {
            Sheet sheet = wb.getSheetAt(0);
            // Decide which rows to process
            int rowStart = Math.min(15, sheet.getFirstRowNum());
//            int rowEnd = Math.max(1400, sheet.getLastRowNum());
            int rowEnd = Math.min(1400, sheet.getLastRowNum());

            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row r = sheet.getRow(rowNum);
                if (r == null) {
                    // This whole row is empty
                    // Handle it as needed
                    continue;
                }

                int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);

                for (int cn = 0; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null) {
                        // The spreadsheet is empty in this cell
                    } else {
                        // Do something useful with the cell's contents
                        System.out.print(c.getStringCellValue() + ", ");
                    }
                }
                System.out.println();
            }

//            pkg.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

