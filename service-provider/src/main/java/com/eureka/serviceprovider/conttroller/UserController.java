package com.eureka.serviceprovider.conttroller;

import com.eureka.serviceprovider.domain.User;
import com.eureka.serviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Integer id) {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        User user = userService.findById(id);
        return user;
    }

}
