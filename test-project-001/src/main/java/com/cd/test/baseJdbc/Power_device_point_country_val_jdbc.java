package com.cd.test.baseJdbc;

import sun.awt.image.OffScreenImage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Power_device_point_country_val_jdbc {
    public static int type = 2;
    static String UP_POINT_ID_VAL_one = "0";
    static String UP_POINT_ID_VAL_second = "2";
    public static String[] oneLevelPoints = {"10663", "10655", "10679", "10671"};
    public static String[] oneLevelPointsID = {"101", "102", "103", "104"};
    public static String[] oneLevelPointsName = {"一级过压保护值", "一级欠压保护值", "一级过频保护值", "一级欠频保护值"};

    public static String[] secondLevelPoints = {"10663", "10667", "10665", "10669", "10655", "10659", "10657", "10661", "10679", "10683", "10681", "10685", "10671", "10675", "10673", "10677"};
    public static String[] secondLevelPointsID = {"105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"};
    public static String[] secondLevelPointsName = {"一级过压保护值", "二级过压保护值", "一级过压保护时间", "二级过压保护时间", "一级欠压保护值", "二级欠压保护值", "一级欠压保护时间", "二级欠压保护时间", "一级过频保护值", "二级过频保护值", "一级过频保护时间", "二级过频保护时间", "一级欠频保护值", "二级欠频保护值", "一级欠频保护时间", "二级欠频保护时间"};


    public static void main(String[] args) {
//        try {
//            insert();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test_db?characterEncoding=utf8&useSSL=true";
//        String url = "jdbc:mysql://192.168.69.55:3306/sungrow?characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static int insert() throws SQLException {
        Connection conn = getConn();
        int index = 0;
//        String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
        String sql = "\n" +
                "insert into `power_device_point_country_val_level` (`RELATION_ID`, `TYPE`, `COUNTRY_ID`, `POINT_ID`, `SET_VAL`, `UP_POINT_ID_VAL`, `POINT_ID_TYPE`, `DEFAULT_VALUE`, `MIN_VALUE`, `MAX_VALUE`, `REMARK`, `CREATE_TIME`, `UPDATE_TIME`) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
//                "values('1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);";
        PreparedStatement pstmt = null;
        try {
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\1级保护参数.xlsx");
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\2级保护参数.xlsx");
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\水晶石Plus单级保护 - 2017-9-19.xlsx");
            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\水晶石Plus多级保护 - 2017-9-19.xlsx");
//            List<Map> list = ReadExcelFileToList.readExcelData("C:\\Users\\Administrator\\Desktop\\水晶石Plus多级保护.xlsx");
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            Integer countryId = null;
            for (int x = 0, y = 0; x < list.size(); x ++) {
                Map map = list.get(x);
                countryId = getCountyId(x);

//                pstmt.setString(1, oneLevelPointsID[y]);//RELATION_ID todo
                pstmt.setString(1, secondLevelPointsID[y]);//RELATION_ID

                pstmt.setString(2, type + "");//TYPE
                pstmt.setString(3, countryId + "");//COUNTRY_ID

//                pstmt.setString(4, oneLevelPoints[y]);//POINT_ID  todo
                pstmt.setString(4, secondLevelPoints[y]);//POINT_ID

                pstmt.setString(5, null);//SET_VAL

//                pstmt.setString(6, UP_POINT_ID_VAL_one);//UP_POINT_ID_VAL todo
                pstmt.setString(6, UP_POINT_ID_VAL_second);//UP_POINT_ID_VAL

                pstmt.setString(7, 2 + "");//POINT_ID_TYPE
                pstmt.setString(8, map.get("DEFAULT_VALUE") + "");//DEFAULT_VALUE
                pstmt.setString(9, map.get("MIN_VALUE") + "");//MIN_VALUE
                pstmt.setString(10, map.get("MAX_VALUE") + "");//MAX_VALUE
                pstmt.setString(11, null);//REMARK
                pstmt.setString(12, null);//create_time
                pstmt.setString(13, null);//update_time
                index = pstmt.executeUpdate();
                if (((x + 1) % 18) == 0) {
                    y ++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            conn.close();
        }
        return index;
    }

    public static Integer getCountyId(int x) {
        x = x % 18;
        Integer countryId = null;
        switch (x) {
            case 0: countryId = 0; break;//英国/GB
            case 1: countryId = 1; break;//德国/DE
            case 2: countryId = 2; break;//法国/FR
            case 3: countryId = 3; break;//意大利/IT
            case 4: countryId = 5; break;//奥地利/AT
            case 5: countryId = 8; break;//比利时/BE
            case 6: countryId = 12; break;//荷兰/NL
            case 7: countryId = 14; break;//中国/CN
            case 8: countryId = 72; break;//卢森堡/Luxembourg
            case 9: countryId = 100; break;//AusGrid
            case 10: countryId = 101; break;//ErgonEnergy
            case 11: countryId = 102; break;//SAPowerNetworks
            case 12: countryId = 103; break;//Powercor
            case 13: countryId = 104; break;//WesternPower
            case 14: countryId = 105; break;//Exergex
            case 15: countryId = 6; break;//Other
            case 16: countryId = 16; break;//Other_50
            case 17: countryId = 62; break;//Other_60
        }
        return countryId;
    }

}
