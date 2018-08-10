package com.zc.springdatajpa.controller;

import com.zc.springdatajpa.entity.Dept;
import com.zc.springdatajpa.entity.Emp;
import com.zc.springdatajpa.repository.DeptRepository;
import com.zc.springdatajpa.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author Kent Lee
 * 2018/8/10
 */
@RestController //@Controller 使用@RestController的时候默认所以的方法都返回JSON字符串，
// 而不是跳转页面，我们也不用在方法上写@ResponseBody
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    @GetMapping("/{id}")
    public Emp findById(@PathVariable("id") Integer id){
        return  empRepository.findById(id).get();
    }

    @GetMapping("/create")
    public Emp create(){
        Emp emp = new Emp();
        emp.setComm(0f);
        emp.setEname("shuaige");
        emp.setHiredate(new Date());
        emp.setJob("Teacher");
        emp.setMgr(null);
        emp.setSal(0f);
        Dept dept = deptRepository.findById(20).get();
        emp.setDept(dept);
        empRepository.save(emp);
        return emp;
    }

    @GetMapping("/find")
    public List<Emp> findEmps(Integer deptno){
        return empRepository.findEmps(deptno);
    }
}
