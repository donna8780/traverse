package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.AccommodationService;

@Controller
@RequestMapping("/member")
public class AccommodationController {

    @Autowired
    private AccommodationService acs;

    @GetMapping("/accommodation")
    public ModelAndView accomlist() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/accommodation");
        return mav;
    }

    @GetMapping("/accommodation/search")
    public ModelAndView searchAccom(@RequestParam("title") String title) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("accommodation", acs.searchByTitle(title));
        mav.setViewName("member/accommodation");
        return mav;
    }
}
