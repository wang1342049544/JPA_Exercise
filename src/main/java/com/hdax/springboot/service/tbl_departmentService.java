package com.hdax.springboot.service;

import com.hdax.springboot.entity.tbl_department;
import com.hdax.springboot.entity.tbl_employee;

import java.util.List;

public interface tbl_departmentService {
    List<tbl_department> findAll();
}
