package com.zc.springdatajpa.repository;

import com.zc.springdatajpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author Kent Lee
 * 2018/8/10
 */

/**
 * JpaRepository 是Spring Boot为我们提供的简化类，默认提供了增删改查方法
 * 我们只需要定义Repository接口就可以了，在SB启动的时候就会自动为我们生成具体的实现类，来实现CRUD方法
 * Dept，Integer 使用JpaRepository需要传入实体类及主键的类型
 */
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    // select * from emp where deptno = ?
    @Query("select e from Emp e where e.dept.deptno = :dn")
    public List<Emp> findEmps(@Param("dn") Integer deptno);
}
