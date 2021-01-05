package com.eureka.serviceconsumer.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author xxc
 * @Date 2021/1/5 15:18
 * @Description TODO
 */
@Component
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
