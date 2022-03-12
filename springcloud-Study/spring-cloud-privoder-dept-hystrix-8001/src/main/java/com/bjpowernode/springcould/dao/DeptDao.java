package com.bjpowernode.springcould.dao;

import com.bjpowernode.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryDept(long id);

    public List<Dept> queryAll();
}
