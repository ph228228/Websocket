package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: penghao
 * @Date: 2017-12-25
 * @Time: 10:38
 */
@RequestMapping(value = "danmu")
@Controller
public class DanmuController {
    @GetMapping(value = "socket")
    public String socket(@RequestParam(required = false) String sign, Map<String,Object> map){
        map.put("sign",sign);
        return "webSocket";
    }

}
