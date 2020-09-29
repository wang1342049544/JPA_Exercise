package com.hdax.springboot.controller;

import com.hdax.springboot.dao.tbl_departmentDao;
import com.hdax.springboot.entity.tbl_department;
import com.hdax.springboot.entity.tbl_employee;

import com.hdax.springboot.service.tbl_departmentService;
import com.hdax.springboot.service.tbl_employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@RequestMapping(path = "/t")
public class tbl_controller {
    @Autowired
    private tbl_employeeService tbl_employeeService;
    @Autowired
    private tbl_departmentService tbl_departmentService;






    /**
     * 跳转inex页面
     * 部门  tbl_departmentService
     * @return
     */
   @GetMapping(path = "/index")
    public ModelAndView index (Model model){
       List<tbl_department> depts = tbl_departmentService.findAll();
       model.addAttribute("depts",depts);
        return new ModelAndView("index");
    }

    /**
     * 跳转add页面
     * @return
     */
    @GetMapping(path = "/add")
    public ModelAndView add(Model model){
        List<tbl_department> depts = tbl_departmentService.findAll();
        model.addAttribute("depts",depts);
        return new ModelAndView("add");
    }


    /**
     * 增加
     * @param emp
     */
    @RequestMapping("/goaddd")
    public void  addEmpp(tbl_employee emp){
        tbl_employeeService.saveEmp(emp);
    }

    /**
     * 增加
     * @param emp
     * @return
     */
    @RequestMapping("/goadd")
    public boolean  addEmp(tbl_employee emp,@RequestParam("did") Integer did){
        try {
            tbl_department t = new tbl_department();
            t.setDid(did);
            emp.setTbl_department(t);
            tbl_employeeService.saveEmp(emp);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public boolean delete(Integer id) {
        try {

            tbl_employeeService.delete(id);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    /**
     * 跳转修改页面
     * @return
     */
    @RequestMapping(path = "/doupdate")
    public ModelAndView update(Model model,@RequestParam("id") Integer id){
        tbl_employee entity = tbl_employeeService.findById(id);
        List<tbl_department> depts = tbl_departmentService.findAll();
        model.addAttribute("depts",depts);
        model.addAttribute("entity",entity);
        return new ModelAndView("update");
    }


    /**
     * 修改
     */
    @RequestMapping(path = "/update")
    public boolean update(tbl_employee entity, @RequestParam("did") Integer did){
        try {
            tbl_department t = new tbl_department();
            t.setDid(did);
            entity.setTbl_department(t);
            tbl_employeeService.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }
    @RequestMapping(path = "/u")
    public void updateInfo(tbl_employee u){
        tbl_employeeService.updateInfo(u);
    }

    /**
     * 分页查询
     * @param condition
     * @param page
     * @param rows
     * @return
     */
    @PostMapping(path = "/list")
    public Map<String,Object> list(tbl_employee condition,@RequestParam(value = "page",defaultValue = "1")Integer page,  @RequestParam(value = "rows",defaultValue = "5")Integer rows  ){
        return tbl_employeeService.findByCondition(condition,page,rows);
    }

    }
