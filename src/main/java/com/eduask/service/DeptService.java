package com.eduask.service;

import com.eduask.beans.Dept;
import com.eduask.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public List<Dept> selectEmps() {
        return deptDao.selectDepts();
    }
}
