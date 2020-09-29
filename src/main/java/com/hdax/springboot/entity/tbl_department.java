package com.hdax.springboot.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 部门表
 */



@Entity
@Table(name="tbl_department")
public class tbl_department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "DID",columnDefinition = "INT(11)")
    private  Integer did;
    @Column(name = "DNAME",columnDefinition = "VARCHAR(255) NOT NULL")
    private  String dname;



    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "tbl_department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
