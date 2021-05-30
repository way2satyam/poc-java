package com.w2s.poc.api;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/{id}")
    public UserData getUserData(@PathVariable String id){
        return userService.getUserData(id);
    }


}
