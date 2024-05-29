package com.busanit.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 일반 MVC 컨트롤러
@Controller
public class GreetingController {

    @GetMapping("/hi")      // HTTP 요청(GET)
    public String niceToMeetYou(Model model) {
        model.addAttribute("message", "점심시간입니다~");  // Model에 데이터를 반영
        return "greetings";         // View로 전달
    }
}
