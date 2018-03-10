package com.cd.test.TaskManagementTest;


import com.cd.test.operation.taskManagement.service.TaskManagementServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-conf.xml", "classpath*:springmvc-servlet.xml"})
public class TaskManagementTest {
    @Autowired
    TaskManagementServiceImpl taskManagementService;

    @Test
    public void textExecutionTest() {
        taskManagementService.excelFileExecution();
    }
}
    