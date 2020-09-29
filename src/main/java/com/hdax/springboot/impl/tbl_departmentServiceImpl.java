package com.hdax.springboot.impl;

import com.hdax.springboot.dao.tbl_departmentDao;
import com.hdax.springboot.entity.tbl_department;

import com.hdax.springboot.service.tbl_departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class tbl_departmentServiceImpl implements tbl_departmentService {
    @Autowired
    private tbl_departmentDao tbl_departmentDao;

    @Override
    public List<tbl_department> findAll() {

        return tbl_departmentDao.findAll();
    }
}
