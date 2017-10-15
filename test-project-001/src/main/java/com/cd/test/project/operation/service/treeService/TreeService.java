package com.cd.test.project.operation.service.treeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChuD on 2017/9/23.
 */
public class TreeService {

    public List queryTreeNodes(Map map) {
        List nodes = new ArrayList();
        Map map1 = new HashMap(); map1.put("id", "10001"); map1.put("name", "node10001");
        Map map2 = new HashMap(); map2.put("id", "10004"); map2.put("name", "node1004");
        Map map3 = new HashMap(); map3.put("id", "10002"); map3.put("name", "node10002"); map3.put("isParent", "true");
        nodes.add(map1);
        nodes.add(map2);
        nodes.add(map3);
        return nodes;
    }
}
