package com.eduask.controller;

import com.eduask.beans.Dept;
import com.eduask.beans.Emp;
import com.eduask.service.DeptService;
import com.eduask.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10.
 */
@SessionAttributes(value = "emp1", types = com.eduask.beans.Emp.class)
@RequestMapping("/HelloWorld")
@Controller
public class HelloWorldController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public EmpService getEmpService() {
        return empService;
    }

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping(value = "/**/hello/{age}", method = RequestMethod.GET, params = {"name", "id!=112"})
    public String printWelcome(Model model, @RequestParam(value = "id") Integer ids,
                               @PathVariable("age") Integer age,
                               @RequestHeader("Connection") String Connection) {
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("ok", emps);
        return "hello";

    }

    @RequestMapping(value = "/empForm", method = RequestMethod.POST)
    public String printEmp(Model model, Emp emp, @CookieValue("JSESSIONID") String cookie) {
        System.out.println(emp);
        model.addAttribute("emp", emp).addAttribute("JSESSIONID", cookie);
        return "hello";
    }

    @RequestMapping(value = "/scopeTest", method = RequestMethod.GET)
    public String scopeTest(Map<String, Object> map) {
        map.put("date", new Date());
        Emp emp1 = new Emp();
        emp1.setEmp_name("jax");
        map.put("emp1", emp1);
        return "hello";
    }

    @RequestMapping(value = "/forward")
    public String forward() {
        return "redirect:http://www.baidu.com";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> map) {
        map.put("emp", new Emp());
        List<Dept> depts = deptService.selectEmps();
        map.put("depts", depts);
        return "edit";
    }

    @RequestMapping(value = "/delEmp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        empService.deleteEmp(id);
        return "redirect:/HelloWorld/123/234/hello/235?id=111&name=jack";
    }

    @RequestMapping(value = "/editPrepare/{id}", method = RequestMethod.PUT)
    public String editPrepare(@PathVariable("id") Integer id, Map<String, Object> map) {
        Emp emp = empService.seleteEmp(id);
        List<Dept> depts = deptService.selectEmps();
        map.put("emp", emp);
        map.put("depts", depts);
        return "edit";
    }

    @RequestMapping(value = "/updateEmp", method = RequestMethod.PUT)
    public String updateEmp(Emp emp) {

            empService.update(emp);

        return "redirect:/HelloWorld/123/234/hello/235?id=111&name=jack";
    }

    @RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
    public String addEmp(@Valid Emp emp,BindingResult bindingResult,Map<String,Object> map) {
        System.out.println("aaaa");
        if (bindingResult.getErrorCount()>0) {
            System.out.println(123123);
            List<Dept> depts = deptService.selectEmps();
            map.put("depts",depts);
            return "edit";
        }
            empService.insertEmp(emp);
        return "redirect:/HelloWorld/123/234/hello/235?id=111&name=jack";
    }
    @ModelAttribute
    public void prepare(Map<String, Object> map, @RequestParam(value = "emp_id",required = false) Integer id,
                        HttpServletRequest request, HttpServletResponse response) {
        if (id != null)
            map.put("emp", empService.seleteEmp(id));
    }
}
