package com.example.controller;

import com.example.beans.Person;
import com.example.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String socket(@RequestParam(value = "roomNum",required = false) String roomNum, Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();

        map.put("roomNum",roomNum);
        return "webSocket";
    }

    @ModelAttribute
    public void prepare(HttpServletRequest request){
        request.setAttribute("model","aaa");
    }
    @GetMapping("/loginPrepare")
    public String loginPrepare(Map<String,Object> map){
        map.put("user",new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(){

        return "redirect:/danmu/socket";
    }
}
