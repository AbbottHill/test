package com.cd.test.baseJdbc;

import com.cd.test.utils.Constants;

import java.util.*;

public class power_device_set_relatioin {

    public static void main(String[] args) {
        String set_relation_sql = "SELECT ID,SERIES,VERSION,MDSP_VERSION,SDSP_VERSION,DEVICE_MODEL_CODE,DEVICE_MODEL_ID,COUNTRY_ID,GRID_TYPE_ID,SET_ID,REMARK,CREATETIME,UPDATETIME FROM" +
                " power_device_set_relation";
        List<Map> power_device_set_relation = CommonJdbc.query(set_relation_sql);

        String country_grid_sql = "SELECT * from power_device_country_grid";
        List<Map> power_device_country_grid = CommonJdbc.query(country_grid_sql);

        List insertList = new ArrayList();
        for (int i = 0; i < power_device_set_relation.size(); i++) {
            Map map = power_device_set_relation.get(i);
            //50hz
            if ("10".equals(String.valueOf(map.get("SET_ID")))) {
                for (int j = 0; j < power_device_country_grid.size(); j++) {
                    Map map_inner = power_device_country_grid.get(j);
                    if ("0".equals(String.valueOf(map_inner.get("GRID_TYPE_ID")))) {
                        Map insertMap = new HashMap();
                        insertMap.put(1, map.get("SERIES"));//SERIES
                        insertMap.put(2, map.get("VERSION"));//VERSION
                        insertMap.put(3, map.get("MDSP_VERSION"));//MDSP_VERSION
                        insertMap.put(4, map.get("SDSP_VERSION"));//SDSP_VERSION
                        insertMap.put(5, map.get("DEVICE_MODEL_CODE"));//DEVICE_MODEL_CODE
                        insertMap.put(6, map.get("DEVICE_MODEL_ID"));//DEVICE_MODEL_ID
                        insertMap.put(7, map_inner.get("COUNTRY_ID"));//COUNTRY_ID
                        insertMap.put(8, map.get("GRID_TYPE_ID"));//GRID_TYPE_ID
                        insertMap.put(9, map.get("SET_ID"));//SET_ID
                        insertMap.put(10, map.get("REMARK"));//REMARK
                        insertMap.put(11, map.get("CREATETIME"));//CREATETIME
                        insertMap.put(12, Constants.SIMPLE_DATE_FORMAT.format(new Date()));//UPDATETIME
                        insertList.add(insertMap);
                    }
                }
            } else if ("11".equals(String.valueOf(map.get("SET_ID")))) {
                for (int j = 0; j < power_device_country_grid.size(); j++) {
                    Map map_inner = power_device_country_grid.get(j);
                    if ("1".equals(String.valueOf(map_inner.get("GRID_TYPE_ID")))) {
                        Map insertMap = new HashMap();
                        insertMap.put(1, map.get("SERIES"));//SERIES
                        insertMap.put(2, map.get("VERSION"));//VERSION
                        insertMap.put(3, map.get("MDSP_VERSION"));//MDSP_VERSION
                        insertMap.put(4, map.get("SDSP_VERSION"));//SDSP_VERSION
                        insertMap.put(5, map.get("DEVICE_MODEL_CODE"));//DEVICE_MODEL_CODE
                        insertMap.put(6, map.get("DEVICE_MODEL_ID"));//DEVICE_MODEL_ID
                        insertMap.put(7, map_inner.get("COUNTRY_ID"));//COUNTRY_ID
                        insertMap.put(8, map.get("GRID_TYPE_ID"));//GRID_TYPE_ID
                        insertMap.put(9, map.get("SET_ID"));//SET_ID
                        insertMap.put(10, map.get("REMARK"));//REMARK
                        insertMap.put(11, map.get("CREATETIME"));//CREATETIME
                        insertMap.put(12, Constants.SIMPLE_DATE_FORMAT.format(new Date()));//UPDATETIME
                        insertList.add(insertMap);
                    }
                }
            }
        }

//        System.out.println(insertList);
        String insert_sql = "insert  into `power_device_set_relation`(" +
                "`SERIES`,`VERSION`,`MDSP_VERSION`,`SDSP_VERSION`,`DEVICE_MODEL_CODE`,`DEVICE_MODEL_ID`," +
                "`COUNTRY_ID`,`GRID_TYPE_ID`,`SET_ID`,`REMARK`,`CREATETIME`,`UPDATETIME`) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        CommonJdbc.insert(insert_sql, insertList);
    }
}
    