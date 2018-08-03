package com.cd.test.json;

import com.alibaba.fastjson.JSON;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FastJSON {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        // JSON.toJSONString
        String s = JSON.toJSONString(map);
        System.out.println(s);
        Object parse = JSON.parse(s);
        System.out.println(parse.getClass());

        // JSON.parseObject
        Map map1 = JSON.parseObject(s, Map.class);
        System.out.println(map1.getClass());

        try {
            FileInputStream fileInputStream = new FileInputStream("projects/test/data/data.json");
            if (fileInputStream == null) {
                throw new IllegalArgumentException();
            }
            HashMap jsonMap = JSON.parseObject(fileInputStream, Map.class);
            Map<String, Object> firstMap = (Map) jsonMap.get("nation_prov_list");
            for (Map.Entry<String, Object> entry : firstMap.entrySet()) {
                System.out.println(entry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
