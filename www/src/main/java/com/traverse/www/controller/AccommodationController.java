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
        mav.addObject("areaCodes", acs.getAllAreaCodes()); // areaCodes를 모델에 추가
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
    
    @GetMapping("/accommodation/area")
    public ModelAndView searchByAreaCode(@RequestParam("areaCode") String areaCode) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("accommodationList", acs.searchByAreaCode(areaCode));
        mav.addObject("areaCodes", acs.getAllAreaCodes()); // areaCodes를 추가
        mav.setViewName("member/accommodation");
        return mav;
    }

}
