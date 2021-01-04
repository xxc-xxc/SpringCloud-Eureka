package com.eureka.serviceconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

@SpringBootTest
class ServiceConsumerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RibbonLoadBalancerClient client;

    /**
     * 测试负载均衡策略
     * 默认的负载均衡策略是：轮询
     */
    @Test
    public void testLoadBalance() {
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = client.choose("service-provider");
            System.out.println(instance.getHost() + ":" +instance.getPort());
        }
    }

}
