package com.cd.test.project.operation.controllers;

import com.cd.test.project.bean.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/25.
 */
@Controller
@RequestMapping("/mvc")
public class TestController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
        User user = new User();
        user.setName("super man");
        model.addAttribute("name", user.getName());
        return "hello";
    }

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest req) {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = req.getSession().getServletContext().getRealPath("/");
        try (FileOutputStream fos = new FileOutputStream(str + sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')))) {
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }

}
