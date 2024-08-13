package com.traverse.www.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.exception.LoginException;

@ControllerAdvice
public class AccountsAdvice {
	@ExceptionHandler(LoginException.class)
	public ModelAndView failLogin(LoginException e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", 1);
		mav.addObject("data", e.getMessage());
		mav.setViewName("member/result");
		
		return mav;
	}
}
