package com.eureka.serviceconsumer.client;

import com.eureka.serviceconsumer.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User findById(Integer id) {

        User user = new User();
        user.setUsername("服务器繁忙，请稍后重试");

        return user;
    }
}
