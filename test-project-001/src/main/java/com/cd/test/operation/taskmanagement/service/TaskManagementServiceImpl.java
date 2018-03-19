package com.cd.test.operation.taskmanagement.service;

import com.alibaba.fastjson.JSON;
import com.cd.test.common.Constants;
import com.cd.test.common.LoggerProxy;
import com.cd.test.common.PoiUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Log4j2
@Service
public class TaskManagementServiceImpl implements TaskManagementService {
    @Autowired
    private LoggerProxy loggerProxy;

    /**
     * 解析Excel文件
     *
     * @return
     */
    @Override
    public List excelFileExecution() {
        List list = new ArrayList();
        // Use a file
        try (Workbook workbook = WorkbookFactory.create(new File(Constants.FILE_PATH + Constants.FILE_NAME))) {
            int numberOfSheets = workbook.getNumberOfSheets();
            //Iterate over Sheets
            for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
                List sheetList = new ArrayList();
                Sheet sheetAt = workbook.getSheetAt(sheetIndex);
                // Decide which rows to process
                int rowStart = Math.min(0, sheetAt.getFirstRowNum());
                int rowEnd = Math.max(1400, sheetAt.getLastRowNum());
                //Iterate over Rows
                for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                    Map rowMap = new HashMap();
                    Row row = sheetAt.getRow(rowNum);
                    if (row == null) {
                        // This whole row is empty
                        // Handle it as needed
                        continue;
                    }

                    //Iterate over Cell
                    int lastColumn = Math.max(row.getLastCellNum(), Constants.MY_MINIMUM_COLUMN_COUNT);
                    for (int cn = 0; cn < lastColumn; cn++) {
                        Cell cell = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                        if (cell == null) {
                            // The spreadsheet is empty in this cell
                            rowMap.put(cn, Constants.REPLACEMENT_EMPTY_STRING);
                        } else {
                            // Do something useful with the cell's contents
//                            rowMap.put(cn, );
                            rowMap.put(cn, PoiUtils.cellValue(cell));
                        }
                    }
                    sheetList.add(rowNum, rowMap);


//                    log.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));
                    loggerProxy.info("excelFileExecution: " + JSON.toJSONString(rowMap));

                }
                list.add(sheetIndex, sheetList);
            }
//            workbook.write(outputStream);
        } catch (IOException e) {
            loggerProxy.error(e);
        } catch (InvalidFormatException e) {
            loggerProxy.error(e);
        }

        return list;
    }

    /**
     *
     * @param rowMap
     * @return
     */
    @Override
    public int addRow(Map rowMap) {
        List taskList = null;
        List sheetsList = this.excelFileExecution();
        if (sheetsList.size() > 0) {
            taskList = (List) sheetsList.get(0);
        }
        if (null != taskList && taskList.size() > 0) {
            taskList.add(1, rowMap);
            try (Workbook wb = new XSSFWorkbook();
                 OutputStream outputStream = new FileOutputStream(Constants.FILE_PATH + Constants.FILE_NAME)
            ) {
                Sheet sheet = wb.createSheet();
                for (int rowIndex = 0; rowIndex < taskList.size(); rowIndex++) {
                    Map taskRow = (Map) taskList.get(rowIndex);
                    Row newRow = sheet.createRow(rowIndex);
                    for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
                        Cell cell = newRow.createCell(columnIndex);
                        cell.setCellValue(String.valueOf(taskRow.get(columnIndex)));
                    }
                }
                wb.write(outputStream);
            } catch (IOException e) {
                loggerProxy.error(e);
            }
        }
        return 1;
    }


}
    