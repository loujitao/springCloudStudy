# springCloudStudy
微服务学习过程中，所有demo源码

01、eurake与服务提供者、消费者案例

     1）eurake服务 
       单机版eureka；高可用配置eurake；
     2）服务提供者
        springBoot中controller接口的几种形式
      
 02、springBoot样例
 
    1）propertiesTest
      springBoot中加载配置文件中的配置属性；
      note记录，springboot属性加载顺序；
      note记录，springBootjar包使用外部属性文件启动
 
 03、eurake测试
 
       1）eurake服务
        单机版eurake服务；
        eurake设置用户名密码；
        eurake监听器，记录服务上下线等日志信息
       2）producer服务提供者
         eurakeClient，根据服务名获取服务实例信息，如IP等
         配置文件中：自定义eurake浏览器的实例名称，显示IP      
       3）Customer     
          通过restTemplate调用eurake下的服务
 
 04、负载均衡测试
 
      1）单机版配置eurake
      2）服务提供者,测试时通过设置port起多个服务，测试负载均衡
      3）ribbon消费者
         restTemplate加上Loadbalance注解；
         ribbonClient消费者；
         自定义rule，负载均衡规则；
      4）feign消费者
         feign客户端消费者；
      5）hystrix消费者
         MyHystrixCommand单类，体验服务降级。组和信号量
         feign集成hystrix，做服务熔断与降级           
         fallbackFactory和fallback两种方式的降级接口
         
 05、zuul网关测试
 
   1）单机版配置eurake
   2）单机版配置服务提供者
   3）zuul服务
      /stevetao/**通配的路由规则；
      集成eurake，默认路由规则；
       自定义过滤器filter；       