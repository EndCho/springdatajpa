package com.zc.springdatajpa.controller;

import com.zc.springdatajpa.entity.Dept;
import com.zc.springdatajpa.repository.DeptRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

/**
 * @Author Kent Lee
 * 2018/8/10
 */
@Controller
@RequestMapping(value = "/dept")
public class DeptController {
    @Resource
    private DeptRepository deptRepository =null;

    @GetMapping("/{id}")
    // 将路径中符合要求的部分，注入到对应的参数中
    // 这种形式成为“路径变量”
    @ResponseBody
    public Dept findById(@PathVariable("id") Integer id){
        // Optional是实体类的包装类，用于判断对象是否存在
        Optional<Dept> op = deptRepository.findById(id);
        // op.isPresent();// 如果传入的id有对应的数据返回true，否则返回false
        Dept dept = null;
        if (op.isPresent() == true){
            // 获取到对应的实体类
            dept = op.get();
        }
        return dept;
    }

    @GetMapping(value = "/create")
    @ResponseBody
    public Dept create(){
        Dept dept = new Dept();
        dept.setDname("trainning");
        dept.setLocation("Hk");
        deptRepository.save(dept);
        // 一旦保存后，JPA会自动将生成的主键回填到id中
        return dept;
    }

    @GetMapping(value = "/update")
    @ResponseBody
    public Dept update(){
        Dept dept = deptRepository.findById(30).get();

        dept.setDname("("+ dept.getDname()+ ")");
        // 在保存的时候，都是save()方法，没有id的时候是新增，有id的时候是修改
        deptRepository.save(dept);
        // 一旦保存后，JPA会自动将生成的主键回填到id中
        return dept;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public Dept delete(){
        Dept dept = deptRepository.findById(40).get();
        deptRepository.delete(dept);
        return dept;
    }

    @GetMapping(value = "/find")
    @ResponseBody
    public List<Dept> findDepts(String dname){
        List<Dept> depts = deptRepository.findDepts(dname);
        return depts;
    }
}
