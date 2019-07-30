package com.steve.listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description: eureka中增加服务上下线监控通知，可以集成邮件短信等做通知，这里只
 * 打印到工作台了
 * @Author: SteveTao
 * @Date: 2019/7/3011:08
 **/
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        //服务下线事件
        System.err.println(event.getServerId()+"\t" +event.getAppName()+"服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        //服务注册事件
        InstanceInfo instanceInfo=event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName()+"进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        System.out.println(event.getServerId()+"\t" + event.getAppName()+"服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event){
        System.out.println("注册中心启动成功");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event){
        System.out.println("Eureka Server 启动");
    }
}
