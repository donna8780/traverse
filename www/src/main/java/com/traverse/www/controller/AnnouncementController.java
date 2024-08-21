package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.AnnouncementService;
import com.traverse.www.service.ReplyService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.AnnouncementVO;
import com.traverse.www.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService as;
	
  
	
	@GetMapping("/write")//글쓰기
	public String write(HttpSession session) {
		
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/member/login";
		}
		
		return "member/write";
	}
	

	@PostMapping("/write")//글쓰기 실행
	public String write(AnnouncementVO input) {
		as.writeAnnouncement(input);
		
		return "redirect:/member/announcement";
	}
	
	// 게시글 보기 : 해당 게시물에 접근하기 위함
	@GetMapping("/view/{announcement_idx}")
	public ModelAndView view(@PathVariable("announcement_idx") int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.getBoardOne(idx));
		mav.setViewName("member/view");
		
		return mav;
	}
	
	// 게시글 삭제
	@GetMapping("/ann_delete/{announcement_idx}")
	public String ann_delete(AnnouncementVO idx) {
		
		as.deleteAccount(idx);
		
		return "redirect:/member/announcement";
	}
	
	// 게시글 수정
	@GetMapping("/ann_update/{announcement_idx}")
	public String update(@PathVariable("announcement_idx") int idx) {
		return "member/ann_update";
	}
	
	// 수정 실행
	@PostMapping("/ann_update/{announcement_idx}")
	public String update(AnnouncementVO input) {
		as.update(input);
		
		return "redirect:/member/announcement";
		
	}
	

}
