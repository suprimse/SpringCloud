package com.bjpowernode.springcould.service.imp;

import com.bjpowernode.springcloud.pojo.Dept;
import com.bjpowernode.springcould.dao.DeptDao;
import com.bjpowernode.springcould.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    @Override
    public boolean addDept(Dept dept) {
        return  dao.addDept(dept);
    }
    @Override
    public Dept queryDept(long id) {
        return dao.queryDept(id);
    }
    @Override
    public List<Dept> queryAll() {
        return dao.queryAll();
    }
}
