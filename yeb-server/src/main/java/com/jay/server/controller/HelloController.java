package com.jay.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello1")
    public String hello1() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello3(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello4(){
        return "/employee/advanced/hello";
    }
}
