package com.hdax.springboot.impl;


import com.hdax.springboot.dao.Tbl_employeeDao;
import com.hdax.springboot.entity.tbl_employee;
import com.hdax.springboot.service.tbl_employeeService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public  class tbl_employeeServiceImpl   implements tbl_employeeService {

    @Autowired
    private  Tbl_employeeDao tbl_employeeDao;

    @Override
    public Map<String, Object> findByCondition(tbl_employee condition,int page, int rows) {
        Pageable pageable = PageRequest.of(page-1, rows);


        Page<tbl_employee> pageObject = tbl_employeeDao.findAll(new Specification<tbl_employee>() {
            @Override
            public Predicate toPredicate(Root<tbl_employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(condition!=null){
                    if(condition.getName() != null  && !condition.getName().trim().equals("")){
                        predicates.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+condition.getName()+"%"));
                    }
                    if(condition.getDid()!= null &&  !condition.getDid().equals("")){
                        predicates.add(criteriaBuilder.equal(root.get("tbl_department"),condition.getDid()));
//
                    }


                }


                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        },pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageObject.getTotalElements());
        map.put("rows",pageObject.getContent());
        return map;
    }

    /**
     * 增加
     * @param entity
     */
    @Override
    public void add(tbl_employee entity) {
        tbl_employeeDao.save(entity);
    }

    /**
     * 增加
     * @param entity
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean saveEmp(tbl_employee entity) throws RuntimeException {

        try {
            tbl_employeeDao.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        try {
            tbl_employeeDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 修改前的查询赋值
     * @param id
     * @return
     */
    @Override
    public tbl_employee findById(Integer id) {
        return   tbl_employeeDao.findById(id).get();
    }

    /**
     * 修改
     * @param u
     */
    @Override
    public void updateInfo(tbl_employee u) {
        tbl_employeeDao.save(u);
    }

    /**
     * 修改
     * @param entity
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean update(tbl_employee entity)  {
        try {
            tbl_employeeDao.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
