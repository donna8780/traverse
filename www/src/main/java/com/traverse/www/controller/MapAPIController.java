package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.MapAPIService;

@Controller
public class MapAPIController {
	
	@Autowired
	private MapAPIService ms;

	@GetMapping("/place/mapAPI")
	public ModelAndView mapAPI() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mapAPI", ms.selectAll());
		
		return mav;
	}
}
