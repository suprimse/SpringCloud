package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;;

//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用id地址
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.bjpowernode.springcloud"})
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
