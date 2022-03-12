package com.bjpowernode.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    /**IRule
     * AvailabilityFilteringRule:会先过滤掉，跳闸，访问故障的服务
     * RoundRobinRule：轮询
     * RandomRule：随机
     * RetryRule：会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
     */
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
