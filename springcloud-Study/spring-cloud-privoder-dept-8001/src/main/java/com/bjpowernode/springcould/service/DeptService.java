package com.bjpowernode.springcould.service;

import com.bjpowernode.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryDept(long id);
    public List<Dept> queryAll();
}
