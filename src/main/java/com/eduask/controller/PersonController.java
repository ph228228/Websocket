package com.eduask.controller;

import com.eduask.beans.Person;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/13.
 */
@RequestMapping("person")
public class PersonController {
    @RequestMapping("addPrepare")
    public String addPrepare(Map<String,Object> map){
        map.put("person",new Person());
        return "addPerson";
    }
    @RequestMapping("addPerson")
    public String addPerson(Person person){

        return "redirect:/index.jsp";
    }
}
