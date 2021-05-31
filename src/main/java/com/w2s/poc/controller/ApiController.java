package com.w2s.poc.controller;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("v1/users/{id}")
    public ResponseEntity<UserData> getUserData(@PathVariable String id) {
        UserData response = userService.getUserData(id);
        return ResponseEntity
                .ok(response);
    }


}
