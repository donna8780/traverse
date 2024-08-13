package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.LikeService;


@Controller
public class LikeController {
   
   @Autowired
   private LikeService like;

   @GetMapping("/member/like")
   public ModelAndView like() {
      ModelAndView mav = new ModelAndView();
      
      mav.addObject("mapAPI", like.getboards());
      
      return mav;
   }


}
