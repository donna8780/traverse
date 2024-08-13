package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService ms;

  @GetMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView();

    mav.setViewName("home");
    
    mav.addObject("test", ms.test());

    return mav;
  }
}
