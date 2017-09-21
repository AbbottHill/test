package com.cd.test.baseJdbc;

import test.com.cd.MyTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public class CommonJdbc {

    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test_db?characterEncoding=utf8&useSSL=true";
////        String url = "jdbc:mysql://192.168.69.55:3306/sungrow?characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static int insert(String sql, List<Map<Integer, String>> list) {
        Connection conn = getConn();
        int index = 0;
//        String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
//        String sql = "\n" +
//                "insert into `POWER_DEVICE_POINT_COUNTRY_VAL` (`RELATION_ID`, `COUNTRY_ID`, `POINT_ID`, `SET_VAL`, `SET_VAL_NAME`, `SET_VAL_NAME_EN_US`, `SET_VAL_NAME_JA_JP`, `DEFAULT_VALUE`, `MIN_VALUE`, `MAX_VALUE`, `REMARK`, `CREATE_TIME`, `UPDATE_TIME`) " +
//                "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
//                "values('1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);";
        PreparedStatement pstmt;
        try {
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\1级保护参数.xlsx");
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\2级保护参数.xlsx");
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            for (int x = 0, y = 0; x < list.size(); x ++) {
                Map<Integer, String> map = list.get(x);
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    pstmt.setString(entry.getKey(), entry.getValue());
                }
                index = pstmt.executeUpdate();
                if (((x + 1) % 18) == 0) {
                    y ++;
                }
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }
}
