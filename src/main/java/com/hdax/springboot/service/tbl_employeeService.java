package com.hdax.springboot.service;

import com.hdax.springboot.entity.tbl_employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface tbl_employeeService {
    Map<String,Object> findByCondition(tbl_employee condition, int page, int rows);
   void add(tbl_employee entity);//增加
    boolean saveEmp(tbl_employee entity) throws RuntimeException; //增加
    boolean delete(Integer id);//删除


    tbl_employee findById(Integer id); //修改前的查询赋值
    void updateInfo(tbl_employee u);
    boolean update(tbl_employee entity)throws RuntimeException; ; //修改
}
