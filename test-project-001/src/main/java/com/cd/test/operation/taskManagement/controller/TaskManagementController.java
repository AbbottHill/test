package com.cd.test.operation.taskManagement.controller;

import com.alibaba.fastjson.JSON;
import com.cd.test.operation.taskManagement.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/taskManagement")
public class TaskManagementController {

    @Autowired
    private TaskManagementService taskManagementService;

    @RequestMapping("/toTaskManagementPage")
    public String toTaskManagementPage() {
        return "/operation/taskManagement/taskManagementMain";
    }

    @RequestMapping("/tasksInfo")
    @ResponseBody
    public List tasksInfo() {
        List result;
        List sheetsList = taskManagementService.excelFileExecution();
        if (sheetsList.size() > 0) {
            result = (List) sheetsList.get(0);
        } else {
            result = new ArrayList();
        }
        return result;
    }

}
    