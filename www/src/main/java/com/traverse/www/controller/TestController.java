package com.traverse.www.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.TestService;

@Controller
public class TestController {

    @Autowired
    private TestService ts;
    
    @GetMapping("/index")
    public void index() {}

    @GetMapping("/getPlaceDetails")
    public ModelAndView getPlaceDetails(@RequestParam("contentId") String contentId) {
        ModelAndView mav = new ModelAndView();
        //HashMap<String, String> placeDetails = ts.getPlaceDetails(contentId);
        
       // mav.addObject("placeDetails", placeDetails);
        
        mav.setViewName("placeDetails"); // view name (Thymeleaf template)
        return mav;
    }
}