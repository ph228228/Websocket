package com.eduask.dao;

import com.eduask.beans.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public interface EmpDao {
    public List<Emp> selectEmp();

    public void insertEmp(Emp emp);
}
