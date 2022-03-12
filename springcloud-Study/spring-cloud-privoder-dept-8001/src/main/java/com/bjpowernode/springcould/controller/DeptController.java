package com.bjpowernode.springcould.controller;


import com.bjpowernode.springcloud.pojo.Dept;
import com.bjpowernode.springcould.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//提供Resful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept queryDept(@PathVariable("id") Long id){
        return service.queryDept(id);
    }
    @GetMapping("/dept/queryAll")
    public List<Dept> queryAll(Dept dept){
        return service.queryAll();
    }
}
