package com.hdax.springboot.dao;

import com.hdax.springboot.entity.tbl_department;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 部门
 *
 */
public interface tbl_departmentDao extends JpaRepository<tbl_department,Integer> {

}
