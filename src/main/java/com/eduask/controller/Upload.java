package com.eduask.controller;

import com.eduask.service.DeptService;
import com.eduask.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/10/13.
 */
@Controller
@RequestMapping("/upup")
public class Upload {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(String desc, @RequestParam("upload") MultipartFile multipartFile) throws Exception {
        System.out.println(multipartFile.getBytes());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getName());
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getSize());
        InputStream is=multipartFile.getInputStream();
        OutputStream os=new FileOutputStream("d:/"+multipartFile.getOriginalFilename());
        byte[] b=new byte[1024];
        int len;
        while((len=is.read(b))!=-1){
            os.write(b,0,len);
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }
    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file =new File("D:/springMVC教程.docx");
        InputStream is=new FileInputStream(file);
//        1、设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=springMVC教程.docx");
//        2、设置响应类型
        response.setContentType("application/x-msdownload");
        OutputStream os=response.getOutputStream();
        byte[] b=new byte[1024];
        int len;
        while ((len=is.read(b))!=-1){
            os.write(b,0,len);
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }

}
