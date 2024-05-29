package com.busanit.spring_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST 컨트롤러
@RestController
public class FirstRestController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello REST API";    // 데이터를 전달
    }
}