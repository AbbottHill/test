package com.cd.test.baseJdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
public class CommonJdbc {

    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        //local
        String url = "jdbc:mysql://127.0.0.1:3306/database_mine?characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "mysqlpass";

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
        int index = 0;
        try (Connection conn = getConn();
             PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql)) {
            for (int x = 0; x < list.size(); x++) {
                Map<Integer, String> map = list.get(x);
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    pstmt.setString(entry.getKey(), String.valueOf(entry.getValue()));
                }
                index = pstmt.executeUpdate();
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }




//    public static ResultSet batchInsert(String sql, List list) {
    public static ResultSet batchInsert() {
//        PreparedStatement pstm = conn.prepareStatement("insert into students(name, email) values(?, ?), (?, ?), (?, ?)",
//                Statement.RETURN_GENERATED_KEYS);
//        pstm.setString(1, "name1");
//        pstm.setString(2, "email1");
//        pstm.setString(3, "name2");
//        pstm.setString(4, "email2");
//
//        pstm.setString(5, "name2");
//        pstm.setString(6, "email2");
//        pstm.addBatch();
//        pstm.executeBatch();
//        ResultSet rs = pstm.getGeneratedKeys();
//        while (rs.next()) {
//            Object value = rs.getObject(1);
//            System.out.println(value);
//        }

//        PreparedStatement pstmt

        String sql = "insert into user (USER_PASSWORD, USER_NAME) values (?, ?),(?, ?)";
        ResultSet resultSet = null;
        try (Connection conn = getConn();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, "eee");
            pstmt.setString(2, "eee");
            pstmt.setString(3, "fff");
            pstmt.setString(4, "fff");
            // must
            pstmt.addBatch();
            pstmt.executeBatch();
            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                Object value = rs.getObject(1);
                System.out.println(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public static List<Map> query(String sql) {
        List<Map> list = new ArrayList();
        try (Connection conn = getConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = pstmt.executeQuery();
            ResultSetMetaData md = resultSet.getMetaData();//获取键名
            int columnCount = md.getColumnCount();//获取行的数量
            while (resultSet.next()) {
                Map rowData = new HashMap();//声明Map
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), resultSet.getObject(i));//获取键名及值
                }
                list.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        // select
//        getConn();
//        String sql = "select * from score";
//        List<Map> query = query(sql);
//        System.out.println(query);

        // batch insert
        batchInsert();

    }

}
