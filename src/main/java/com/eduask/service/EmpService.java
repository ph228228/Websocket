package com.eduask.service;

import com.eduask.beans.Emp;
import com.eduask.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    public EmpDao getEmpDao() {
        return empDao;
    }

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }
    public List<Emp> getAllEmps(){
        return empDao.selectEmp();
    }

    public void insertEmp(Emp emp) {
        empDao.insertEmp(emp);
    }
}
