package com.traverse.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.WeatherService;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService ws;
	
	@GetMapping("/weather")
	public ModelAndView getWeather(@RequestParam(name = "city", defaultValue = "Seoul") String city) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> weather = ws.getWeather(city);
		
		mav.addObject("weather", weather);
		mav.addObject("city", city);
		
		return mav;
	}
}
