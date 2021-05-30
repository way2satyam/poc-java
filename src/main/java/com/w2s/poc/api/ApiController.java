package com.w2s.poc.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping("/status")
    public HttpStatus isServerRunning(){
        return HttpStatus.OK;
    }


}
