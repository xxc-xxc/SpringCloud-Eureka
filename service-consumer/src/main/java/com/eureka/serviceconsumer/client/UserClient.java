package com.eureka.serviceconsumer.client;

import com.eureka.serviceconsumer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-provider", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("user/{id}")
    User findById(@PathVariable("id") Integer id);

}
