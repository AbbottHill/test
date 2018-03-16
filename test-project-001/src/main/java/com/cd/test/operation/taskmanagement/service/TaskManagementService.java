package com.cd.test.operation.taskmanagement.service;

import java.util.List;
import java.util.Map;

public interface TaskManagementService {

    List excelFileExecution();

    int addRow(Map row);
}