package com.example.dao;

import com.example.beans.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
@Repository
public interface DeptDao {
    public List<Dept> selectDepts();
}
