package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启监控器
public class DeptConsumer_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_9001.class,args);
    }
}
