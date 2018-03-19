package com.cd.test.TaskManagementTest;


import com.cd.test.common.Constants;
import com.cd.test.operation.taskmanagement.service.TaskManagementServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-conf.xml", "classpath*:springmvc-servlet.xml"})
public class TaskManagementTest {
    @Autowired
    TaskManagementServiceImpl taskManagementService;

    @Test
    public void textExecutionTest() {
        taskManagementService.excelFileExecution();
    }

    @Test
    public void addRowTest() {
        Map rowMap = new HashMap();
        rowMap.put(0, Constants.SIMPLE_DATE_FORMAT.format(new Date()));
        rowMap.put(1, "unit test");
        taskManagementService.addRow(rowMap);
    }

}
    