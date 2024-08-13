package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.CustomerService.CustomerService;
import com.traverse.www.service.AnnouncementService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private AnnouncementService as;


	
	//고객지원으로 이동해서 qna섹션을 누르면 이동
	@GetMapping("/customer")
	public ModelAndView csboard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", cs.cstest());
		mav.addObject("announce", as.announce());
		return mav;
	}
	//글쓰기
	@GetMapping("/cswrite")
	public String cswrite(HttpSession session) {
		//세션때문에 유저정보를 가져와야되니까 accountvo클래스
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		
		if(user == null) {
			return "redirect:/member/login";
		}		
		return "member/cswrite";	
	}
	


}
