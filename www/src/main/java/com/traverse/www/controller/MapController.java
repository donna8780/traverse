package com.traverse.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

	 @GetMapping("/map")
	    public String index() {
	        return "redirect:/index.html"; // static/index.html을 반환
	    }
}
