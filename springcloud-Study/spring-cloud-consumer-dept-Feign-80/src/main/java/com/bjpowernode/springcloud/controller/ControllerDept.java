package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.pojo.Dept;
import com.bjpowernode.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
public class ControllerDept {
    /**
     * 服务熔断：服务端，某个超时或者异常，引起熔断，保险丝
     *
     * 服务降级：客户端：从整体网站请求负载考虑，当某个服务熔断或者关闭之后，服务将不必调用
     *          我们在客户端可以给一个FallbackFactory,客户端给他返回一个默认的值（缺省）。整体服务水平下降了
     *          但是比直接挂掉了强
     */

    @Resource
    private DeptClientService service=null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> queryAll(){
        return service.queryList();
    }


}
