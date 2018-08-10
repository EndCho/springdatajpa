package com.zc.springdatajpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Kent Lee
 * 2018/8/10
 */
@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Float sal;
    private Float comm;


    // ept 与Emp的关系是1对多关系，一个部门有多个员工
    @ManyToOne //在多的一方使用ManyToOne 多对一
    @JoinColumn(name = "deptno")//指定关联一的一方的关联字段，通常是主键
    //只要获取dept的时候，会自动查询 select * from dept where deptno = ...
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public Float getComm() {
        return comm;
    }

    public void setComm(Float comm) {
        this.comm = comm;
    }

//    public Integer getDeptno() {
//        return deptno;
//    }
//
//    public void setDeptno(Integer deptno) {
//        this.deptno = deptno;
//    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }



}
