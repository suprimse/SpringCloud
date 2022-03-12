package com.bjpowernode.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ZhangRandomRule extends AbstractLoadBalancerRule {

    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    //total=0，默认=0，如果=5，就切换下一个节点
    //index=0, 默认0，如果total=5，index+1
    private int total=0;//被调用的次数
    private int cur=0;//当前是谁在服务
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//获得活着的服务
            List<Server> allList = lb.getAllServers();//获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

           /* int index = chooseRandomInt(serverCount);//生成区间随便数
            server = upList.get(index);//从活着的服务随机获取一个*/
            //=====================================================自定义代码区间
            if (total<5){
                server=upList.get(cur);
                total++;
            }else {
                total=0;
                cur++;
                if (cur>upList.size()){
                    cur=0;
                }
                server= upList.get(cur);
            }
            //=====================================================


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
