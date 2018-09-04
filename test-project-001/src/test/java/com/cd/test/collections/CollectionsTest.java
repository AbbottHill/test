package com.cd.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"a", "c", "b"});
        System.out.println("list.contains: " + list.contains(new String("a")));
        list.stream().forEach(System.out:: println);

        // 默认升序
        Collections.sort(list);
        list.stream().forEach(System.out:: println);
    }
}
