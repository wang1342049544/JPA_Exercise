package com.hdax.springboot.dao;


import com.hdax.springboot.entity.tbl_employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * 员工表
 */
public interface Tbl_employeeDao  extends JpaRepository<tbl_employee,Integer>, JpaSpecificationExecutor<tbl_employee> {




}
