package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traverse.www.service.signUpSercive;
import com.traverse.www.vo.AccountsVO;

@Controller
@RequestMapping("/member")
public class signUpController {
	
	@Autowired
	private signUpSercive ss;
	
	//회원가입 폼
	@GetMapping("/signUp")
		public void signUp() {
		}
	
	//회원가입 입력
	@PostMapping("/signUp")
	public String signUp(AccountsVO input) {
		
		ss.addAccount(input);
		return "redirect:/";
	}
	
}				