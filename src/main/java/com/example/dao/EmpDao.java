package com.example.dao;

import com.example.beans.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
@Repository
public interface EmpDao {
    public List<Emp> selectEmps();

    public void insertEmp(Emp emp);

    public void deleteEmp(Integer id);

    public Emp selectEmp(Integer id);

    public void update(Emp emp);
}
