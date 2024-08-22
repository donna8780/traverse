package com.traverse.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {

    @GetMapping("/member/location")
    public String index() {
        return "/member/location"; // index.html을 반환
    }
}
