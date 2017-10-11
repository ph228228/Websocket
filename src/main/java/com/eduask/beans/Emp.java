package com.eduask.beans;

/**
 * Created by Administrator on 2017/10/10.
 */
public class Emp {
    private Integer emp_id;
    private String emp_name;
    private String sex;
    private String address;
    private Dept dept;

    public Emp() {
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
                ", dept=" + dept +
                '}';
    }
}
