package com.steve.compent;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Description: 在yml文件中通过参数可以指定自定义负载均衡策略
 * @Author: SteveTao
 * @Date: 2019/7/3016:50
 **/
public class MyRule implements IRule {

    private  ILoadBalancer lb;

    /**
    *@Author: SteveTao
    *@Description: 负载均衡策略核心方法，选择服务实例的算法方式
    *@Date: 16:51 2019/7/30
    **/
    @Override
    public Server choose(Object o) {
        List<Server> servers=lb.getAllServers();
        for (Server server:servers  ) {
            System.out.println(server.getHostPort());
        }
        //每次都取第一个实例
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
