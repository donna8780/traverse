package com.traverse.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TraverserStoryController {

	@GetMapping("/place/traverserStory")
	public void traverserStory() {}
	
	@PostMapping("/place/traverserStory")
	public ModelAndView traverserStory(@RequestParam("search") String search) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("search", search);
		mav.setViewName("/place/tsResult");
		
		return mav;
	}
}
