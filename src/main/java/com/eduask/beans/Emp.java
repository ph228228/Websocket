package com.eduask.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/10/10.
 */
public class Emp {
    private Integer emp_id;
    @NotEmpty
    private String emp_name;
    private String sex;
    private String address;
    @NumberFormat()
    @Max(120)
    @Min(1)
    private Integer age;
    @NumberFormat(pattern = "###,###.###")
    private Double salary;
    private Dept dept;

    public Emp() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }
}
