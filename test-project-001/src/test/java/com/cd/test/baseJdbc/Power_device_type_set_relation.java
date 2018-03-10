package com.cd.test.baseJdbc;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Power_device_type_set_relation {
    public static void main(String[] args) {
        String sql = "INSERT INTO `power_device_type_set_relation` (`VERSION`, `MDSP_VERSION`, `LDSP_VERSION`, `MODULE_CODE`, `COUNTRY_ID`, `GRID_TYPE`, `SET_ID`, `REMARK`, `CREATETIME`, `UPDATETIME`) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//                "VALUES('20','V31\\r\\n','V013\\r\\n','V10','SG2K5-S','6',NULL,'7',NULL,NULL,NULL);";
//        List<Map<Integer, String>> list = parseExcel("C:\\Users\\Administrator\\Desktop\\户用机型+机器版本号+主DSP版本号+国家.xls");
        List<Map<Integer, String>> list = parseExcel("C:\\Users\\Administrator\\Desktop\\power device\\户用机型+机器版本号+主DSP版本号+国家 - 2003.xls");
        CommonJdbc.insert(sql, list);
    }

    private static List<Map<Integer, String>> parseExcel(String filePath) {
        List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = Workbook.getWorkbook(fis);
            Sheet[] sheets = workbook.getSheets();
            Sheet sheet0 = sheets[0];
            int rows = sheet0.getRows();
            for (int j = 1; j < rows; j++) {
                Cell[] cells = sheet0.getRow(j);
                Map<Integer, String> params = new HashMap<Integer, String>();
                params.put(1, cells[1].getContents());//VERSION
                params.put(2, cells[2].getContents());//MDSP_VERSION
                params.put(3, cells[3].getContents());//LDSP_VERSION
                params.put(4, cells[0].getContents());//MODULE_CODE
                params.put(5, cells[4].getContents());//COUNTRY_ID
                params.put(6, null);//GRID_TYPE
                params.put(7, cells[5].getContents());//SET_ID
                params.put(8, null);//REMARK
                params.put(9, null);//CREATETIME
                params.put(10, null);//UPDATETIME
                list.add(params);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return list;
    }
}
