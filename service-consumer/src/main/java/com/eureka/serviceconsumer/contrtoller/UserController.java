package com.eureka.serviceconsumer.contrtoller;

import com.alibaba.fastjson.JSON;
import com.eureka.serviceconsumer.client.UserClient;
import com.eureka.serviceconsumer.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//@DefaultProperties(defaultFallback = "fallBackMethod") // 类级别的熔断方法
@RestController
@RequestMapping("consumer/user")
public class UserController {

//    @Autowired
//    private RestTemplate restTemplate;

    // 获取eureka客户端
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

    /**
     * @HystrixCommand：方法级别的熔断
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "queryUserByIdFallBack")
//    @HystrixCommand
    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Integer id){
        // 获取服务实例集合
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-provider");
//        ServiceInstance instance = instanceList.get(0);
//        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        // 模拟请求失败
//        if (id == 1) {
//            throw new RuntimeException("服务正忙");
//        }

//        String baseUrl = "http://service-provider/user/" + id;
//        String userStr = this.restTemplate.getForObject(baseUrl, String.class);
//        User user = this.restTemplate.getForObject(baseUrl, User.class);
//        System.out.println(userStr);
//        User user = userClient.findById(id);
        return userClient.findById(id);
    }

//    /**
//     * 方法返回值和参数要与被熔断的方法返回值和参数一致
//     * @param id
//     * @return
//     */
//    public String queryUserByIdFallBack(Integer id) {
//        return "服务繁忙，请稍后重试";
//    }

//    /**
//     * 熔断方法
//     * 返回值要和被熔断的方法的返回值一致
//     * 熔断方法不需要参数
//     * @return
//     */
//    public String fallBackMethod(){
//        return "请求繁忙，请稍后再试！";
//    }

}
