package java.com.cd.test.baseJdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileToList {

    public static void main(String[] args) {
//        readExcelData("C:\\Users\\Administrator\\Desktop\\1 - 10663.xlsx");
    }

    //C:\Users\Administrator\Desktop\1 - 10663.xlsx
    public static List<Map> readExcelData(String fileName) {
        List<Map> itemsList = new ArrayList<Map>();
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (fileName.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();
            //loop through each of the sheets
            for (int i = 0; i < numberOfSheets; i++) {
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);


                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    String maxValue = "";
                    String minValue = "";
                    String defValue = "";

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        //Get the Cell object
                        Cell cell = cellIterator.next();
                        //check the cell type and process accordingly
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                String range = cell.getStringCellValue();
                                String[] rangeArr = range.split("～");
                                minValue = rangeArr[0];
                                maxValue = rangeArr[1];

//                                System.out.println("string data:" + range + "; " + minValue + " - " + maxValue);
//                                if (shortCode.equalsIgnoreCase("")) {
//                                    shortCode = cell.getStringCellValue().trim();
//                                    System.out.println("string data::" + cell.getStringCellValue());
//                                } else if (name.equalsIgnoreCase("")) {
//                                    //2nd column
//                                    name = cell.getStringCellValue().trim();
//                                    System.out.println("string data::" + cell.getStringCellValue());
//                                } else {
//                                    //random data, leave it
//                                    System.out.println("string data::" + cell.getStringCellValue());
//                                }
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                defValue = (int)cell.getNumericCellValue() + "";
                                System.out.println("numeric data::" + (int)cell.getNumericCellValue());
                        }
                    } //end of cell iterator
//                    Country c = new Country(name, shortCode);
                    Map map = new HashMap();
                    map.put("MIN_VALUE", minValue);
                    map.put("MAX_VALUE",maxValue);
                    map.put("DEFAULT_VALUE",defValue);
                    itemsList.add(map);
                } //end of rows iterator
            } //end of sheets for loop
            //close file input stream
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}

