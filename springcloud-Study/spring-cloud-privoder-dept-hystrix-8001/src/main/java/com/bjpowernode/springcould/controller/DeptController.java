package com.bjpowernode.springcould.controller;

import com.bjpowernode.springcloud.pojo.Dept;
import com.bjpowernode.springcould.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Resful服务
@RestController
public class DeptController {/*
    @Autowired
    private DeptService service;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixDept")
    public Dept queryDept(@PathVariable("id") Long id){
        Dept dept=service.queryDept(id);
        if (id==null){
            throw new RuntimeException("id=>"+id+"信息无法找到");
        }
        return dept;
    }
    //备选方法
    public Dept hystrixDept(@PathVariable("id") Long id){
        Dept dept=service.queryDept(id);
        return new Dept().setDeptno(id).setDname("用户信息无法找到").setDb_source("no this DataBase");
    }*/
    @Autowired
    private DeptService deptService;
    /**
     * 根据id查询部门信息
     * 如果根据id查询出现异常,则走hystrixGet这段备选代码
     * @param id
     * @return
     */
    @GetMapping("/dept/get/{id}")//根据id查询
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryDept(id);
        if (dept==null){
            throw new RuntimeException("这个id=>"+id+",不存在该用户，或信息无法找到~");
        }
        return dept;
    }
    /**
     * 根据id查询备选方案(熔断)
     * @param id
     * @return
     */
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("这个id=>"+id+",没有对应的信息,null---@Hystrix~")
                .setDb_source("在MySQL中没有这个数据库");
    }
}
