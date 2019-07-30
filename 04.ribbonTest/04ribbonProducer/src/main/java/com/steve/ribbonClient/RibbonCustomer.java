package com.steve.ribbonClient;
//
//import com.google.common.collect.Lists;
//import com.netflix.loadbalancer.ILoadBalancer;
//import com.netflix.loadbalancer.LoadBalancerBuilder;
//import com.netflix.loadbalancer.Server;
//import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
//import com.netflix.loadbalancer.reactive.ServerOperation;
//import rx.Observable;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
///**
// * @Description: TODO
// * @Author: SteveTao
// * @Date: 2019/7/3011:44
// **/
//public class RibbonCustomer {
//
//    public static void main(String[] args) {
//        //服务列表
//        List<Server> serverList= Lists.newArrayList(
//                new Server("localhost",8080),
//                new Server("localhost",8082)
//        );
//        //构建负载实例
//        ILoadBalancer loadBalancer= LoadBalancerBuilder.newBuilder()
//                        .buildFixedServerListLoadBalancer(serverList);
//        //调用5次来调试效果
//        for(int i=0;i<5;i++){
//            String result= LoadBalancerCommand.<String>builder()
//                    .withLoadBalancer(loadBalancer)
//                    .build()
//                    .submit(new ServerOperation<String>() {
//                        @Override
//                        public Observable<String> call(Server server) {
//                            try {
//                                String addr="http://"+server.getHost()+":"+server.getPort()+"/person/hello";
//                                System.out.println("调用URL :"+addr);
//                                URL url=new URL(addr);
//                                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
//                                conn.setRequestMethod("GET");
//                                conn.connect();
//                                InputStream in=conn.getInputStream();
//                                byte[] data=new byte[in.available()];
//                                in.read(data);
//                                return Observable.just(new String(data));
//                            } catch (IOException e) {
//                                return Observable.error(e);
//                            }
//                        }
//                    }).toBlocking().first();
//            System.out.println("调用结果："+result);
//        }
//
//    }
//
//}
