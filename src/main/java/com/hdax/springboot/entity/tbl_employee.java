package com.hdax.springboot.entity;


import javax.persistence.*;

import javax.xml.soap.Name;
import java.io.Serializable;

/**
 * 员工表
 * @Table注解用来标识实体类与数据表的对应关系类似，@Column注解来标识实体类中属性与数据表中字段的对应关系。
 */
@Entity
@Table(name = "tbl_employee")  //实体类
public class tbl_employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @Column(name = "ID",columnDefinition = "INT(50)")
    private  Integer id;

    @Column(name = "NAME",columnDefinition = "VARCHAR(50) NOT NULL")
    private  String name;


    @Transient
    private Integer did;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "did",columnDefinition = "INT(11) NOT NULL")
    private tbl_department tbl_department;


















    public com.hdax.springboot.entity.tbl_department getTbl_department() {
        return tbl_department;
    }

    public void setTbl_department(com.hdax.springboot.entity.tbl_department tbl_department) {
        this.tbl_department = tbl_department;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tbl_employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
