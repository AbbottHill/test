package com.cd.test.operation.taskmanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("taskManagementService")
public interface TaskManagementService {

    List excelFileExecution();

    int addRow(Map row);
}