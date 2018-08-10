package com.zc.springdatajpa.repository;

import com.zc.springdatajpa.entity.Dept;
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
public interface DeptRepository extends JpaRepository<Dept, Integer> {
    // select * from dept where dname =...

    public List<Dept> findByDname(String dname);

    /**
     * 类sql语言，从sql转化为JPQL只需注意一下几点：
     * 1.大多数情况下将* 替换为别名
     * 2.表名改为类名 Dept
     * 3.字段名改为属性名 location
     * select * from dept d where d.dname = ? order by deptno desc
     * :dn是命名参数，其本质就是一个占位符
     * @param dname
     * @return
     */
    @Query(value = "select d from Dept d where d.dname = :dn order by deptno desc" )
    public List<Dept> findDepts(@Param("dn") String dname);
}
