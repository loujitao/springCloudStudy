package com.steve.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.Future;

/**
 * @Description: 单独的类，体验hystrix的失败回调和线程隔离等
 * @Author: SteveTao
 * @Date: 2019/8/111:43
 **/
public class MyHystrixCommand extends HystrixCommand<String> {

    private  final String name;

    public MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        try {
            //2、增加回退方法 加上超时时间
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name+":"+Thread.currentThread().getName();
    }

    //2、增加回退方法  加上超时，再执行下面的main方法
    @Override
    protected String getFallback() {
        return "失败了！";
    }

    public static void main(String[] args) throws  Exception{
        //同步调用
//        String result=new MyHystrixCommand("stevetao").execute();
//        System.out.println(result);
        //异步调用
        Future<String>  future=new MyHystrixCommand("stevetao").queue();
        System.out.println(future.get());
    }
}
