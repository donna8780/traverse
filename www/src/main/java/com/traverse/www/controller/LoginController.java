package com.traverse.www.controller;


import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.exception.LoginException;
import com.traverse.www.service.LoginService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member/")
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(AccountsVO input,HttpSession session) throws LoginException, NoSuchAlgorithmException {
		
		session.setAttribute("user", ls.getAccounts(input));	
		return "redirect:/";

	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	@GetMapping("findID")
	public void findID() {}
	
	@PostMapping("findID")
	public ModelAndView findID(AccountsVO input) {
		ModelAndView mav = new ModelAndView();
		int row = 1;
		
		String msg = "회원님의 ID는 "+ls.findID(input)+" 입니다";
		
		if(ls.findID(input) == null) {
			msg = "일치하는 정보가 존재하지 않습니다";
		}
		
		mav.addObject("data", msg);
	  
	  Object value = mav.getModel().get("data");
	  if(value == null) row = 0;

	  mav.addObject("row", row);
		mav.setViewName("member/result");
		
		return mav;
	}
	
	@GetMapping("findPW")
	public void findPW() {}
	
	@PostMapping("findPW")
	public ModelAndView findPW(AccountsVO input) throws LoginException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("accounts_idx", ls.findPW(input));
		mav.setViewName("member/newPW");
		
		return mav;
	}
	
	
	@PostMapping("newPW")
	public ModelAndView newPW(AccountsVO input) throws NoSuchAlgorithmException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("newPW", ls.newPW(input));
		mav.setViewName("redirect:/member/login");
		
		return mav;
	}
}
