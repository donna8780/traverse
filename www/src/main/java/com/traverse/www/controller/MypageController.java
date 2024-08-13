package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traverse.www.service.MyPageService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MypageController {
	
	@Autowired
	MyPageService ms;
	
	@GetMapping("/myPage")
	public void mypage() {}
	
	@GetMapping("/update")
	public void update() {}
	
	@PostMapping("/update")
	public String update(AccountsVO input) {
		ms.update(input);
		return "redirect:/";
	}
}
