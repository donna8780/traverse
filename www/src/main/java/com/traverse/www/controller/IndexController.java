package com.traverse.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/member/index")
    public String index() {
        return "/member/index.html"; // index.html을 반환
    }
}
