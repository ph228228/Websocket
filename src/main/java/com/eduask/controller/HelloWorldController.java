package com.eduask.controller;

import com.eduask.beans.Emp;
import com.eduask.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10.
 */
@SessionAttributes(value = "emp1",types = com.eduask.beans.Emp.class)
@RequestMapping("/HelloWorld")
@Controller
public class HelloWorldController {
    @Autowired
    private EmpService empService;

    public EmpService getEmpService() {
        return empService;
    }

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping(value="/**/hello/{age}" ,method = RequestMethod.GET,params = {"name","id!=112"})
    public String printWelcome(Model model, @RequestParam(value = "id") Integer ids,
                               @PathVariable("age") Integer age,
                               @RequestHeader("Connection") String Connection) {
        List<Emp> emps=empService.getAllEmps();
        System.out.println("emps = [" + emps + "]");
        model.addAttribute("ok", emps);
        System.out.println("ids = [" + ids + "]");
        System.out.println("age = [" + age + "]");
        System.out.println("Connection = [" + Connection + "]");
        return "hello";

    }
    @RequestMapping(value = "/empForm",method = RequestMethod.POST)
    public String printEmp(Model model,Emp emp,@CookieValue("JSESSIONID") String cookie){
        System.out.println(emp);
        model.addAttribute("emp",emp).addAttribute("JSESSIONID",cookie);
        return "hello";
    }
    @Transactional
    @RequestMapping(value = "/insertEmp",method = RequestMethod.POST)
    public String insertEmp(Model model,Emp emp){
        empService.insertEmp(emp);
        return "hello";
    }
    @RequestMapping(value = "/scopeTest",method = RequestMethod.GET)
    public String scopeTest(Map<String,Object> map){
        map.put("date",new Date());
        Emp emp1 =new Emp();
        emp1.setEmp_name("jax");
        map.put("emp1",emp1);
        return "hello";
    }
    @RequestMapping(value = "/forward")
    public  String forward(){
        return "redirect:http://www.baidu.com";
    }
    @RequestMapping(value = "/add")
    public  String add(Map<String,Object> map){
        map.put("emp",new Emp());

        return "add";
    }

}
