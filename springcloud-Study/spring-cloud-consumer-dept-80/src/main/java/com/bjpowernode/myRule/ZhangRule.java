package com.bjpowernode.myRule;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义负载均衡的算法
@Configuration
public class ZhangRule {
    @Bean
    public IRule myRule(){
        return new AvailabilityFilteringRule();
    }
}
