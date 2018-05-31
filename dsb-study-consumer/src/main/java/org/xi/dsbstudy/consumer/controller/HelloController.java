package org.xi.dsbstudy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xi.dsbstudy.consumer.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/helloName")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
