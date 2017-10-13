package com.eduask.controller;

import com.eduask.service.DeptService;
import com.eduask.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
    public void upload(MultipartFile multipartFile) {

    }


}
