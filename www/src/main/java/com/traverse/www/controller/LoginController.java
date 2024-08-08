package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.LoginService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@GetMapping("member/login")
	public void login() {}
	
	@PostMapping("member/login")
	public String login(AccountsVO input,HttpSession session) {
		
		session.setAttribute("user", ls.getAccounts(input));
		
		return "redirect:/member/login";
		
	}
	
	@GetMapping("member/findID")
	public void findID() {}
	
	@PostMapping("member/findID")
	public ModelAndView findID(AccountsVO input) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", ls.findID(input));
		mav.setViewName("member/resultID");
		
		return mav;
	}
	
	@GetMapping("member/findPW")
	public void findPW() {}
}
