package com.eureka.serviceconsumer.contrtoller;

import com.eureka.serviceconsumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    // 获取eureka客户端
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        // 获取服务实例集合
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-provider");
//        ServiceInstance instance = instanceList.get(0);
//        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        String baseUrl = "http://service-provider/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        System.out.println(user);
        return user;
    }

}
