package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.AnnouncementService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.AnnouncementVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService as;
	
	@GetMapping("/announcement")
	public ModelAndView announcement() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("test", as.test());
		
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpSession session) {
		
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/member/login";
		}
		
		return "member/write";
	}
	
	@PostMapping("/write")
	public String write(AnnouncementVO input) {
		as.writeAnnouncement(input);
		
		return "redirect:/";
	}

}
