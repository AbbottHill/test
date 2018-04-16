package com.cd.test.operation.taskmanagement.controller;

import com.cd.test.base.BaseController;
import com.cd.test.utils.Constants;
import com.cd.test.utils.LoggerProxy;
import com.cd.test.operation.taskmanagement.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/taskManagement")
public class TaskManagementController  extends BaseController {
    @Autowired
    LoggerProxy loggerProxy;

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

    @RequestMapping("/addTask")
    @ResponseBody
    public Map addTask(HttpServletRequest request) {
        String fileName = "";
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("pic");
        if (null != file) {
            fileName = file.getOriginalFilename();
            if (fileName.length() > 10) {
                fileName = fileName.substring(0, 10);
            }
            fileName = Constants.FILE_NAME_TIME_RORMAT.format(new Date()) + "-" + fileName;
            try (FileOutputStream fileOutputStream = new FileOutputStream(Constants.IMAGE_FILE_PATH + fileName)){
                byte[] bytes = file.getBytes();
                //BASE64 code
//                System.out.println("bytes: " + bytes);
//                String encode = new BASE64Encoder().encode(bytes);
//                System.out.println("encode: " + encode);
//                byte[] bytes1 = new BASE64Decoder().decodeBuffer(encode);
//                System.out.println("bytes1: " + bytes1);
                fileOutputStream.write(bytes);
            } catch (IOException e) {
                loggerProxy.error(e);
            }
        }
        Map rowMap = new HashMap();
        rowMap.put(0, Constants.SIMPLE_DATE_FORMAT.format(new Date()));
        rowMap.put(1, multipartRequest.getParameter("task_content"));
        rowMap.put(2, fileName);

        int x = 1/0;

        taskManagementService.addRow(rowMap);
        // Servlet way
//        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
//        MultipartFile file = multipartRequest.getFile("pic");
//        String a1 = multipartRequest.getParameter("task_content");
//        System.out.println(file);
//        System.out.println(a1);

        return null;
    }

    @RequestMapping("/loadImg")
    public void loadImg(HttpServletResponse response, @RequestParam String imgName) {
        String path = Constants.IMAGE_FILE_PATH + imgName;

        try (FileInputStream fileInputStream = new FileInputStream(path);
             ServletOutputStream outputStream = response.getOutputStream()
        ) {
            byte[] bts = new byte[2];
            while (fileInputStream.read(bts) != -1) {
                outputStream.write(bts);
            }
        } catch (FileNotFoundException e) {
            loggerProxy.error(e);
        } catch (IOException e) {
            loggerProxy.error(e);
        }
    }

}
    