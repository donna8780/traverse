package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.MainService;
import com.traverse.www.vo.TestVO;

@Controller
public class MainController {
	
	@Autowired
	private MainService ms;

  @GetMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView();

    //TestVO per = new TestVO();
    //per.setName("홍길동");
    //per.setAge(22);
    
    //mav.addObject("per", per);
    mav.setViewName("home");
    
    mav.addObject("test", ms.test());

    return mav;
  }
}
