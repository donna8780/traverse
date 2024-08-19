package com.traverse.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.AnnouncementService;
import com.traverse.www.service.CustomerService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.CustomerVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private AnnouncementService as;

	//고객지원에서 qna섹션을 누르면 이동
	@GetMapping("/customer")
	public ModelAndView csboard(@RequestParam(value = "idx", required = false) Integer idx) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> announceMap = as.announce(idx);

		mav.addObject("pg", announceMap.get("pg"));
		mav.addObject("announce", announceMap.get("list"));
		
		return mav;
	}
	//글쓰기
	@GetMapping("/cswrite")
	public String cswrite(HttpSession session) {
		//세션때문에 유저정보를 가져와야되니까 accountvo클래스
		//accountsvo에 있는 계정을 user에 저장해서 로그인된 계정을 사용하기 위해(세션에 저장 되어있는)
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		
		if(user == null) {
			return "redirect:/member/login";
		}		
		return "member/cswrite";	
	}
	//Q&A 글쓰기 실행
	@PostMapping("/cswrite")
	public String cswrite(CustomerVO input)
	{
		cs.cusWrite(input);
		return "redirect:/member/customer";
	} 
	//Q&A 하나의 게시글 보기
	@GetMapping("/csView/{board_idx}")
	public ModelAndView csview(@PathVariable("board_idx")int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", cs.getCsBoardOne(idx));
		mav.setViewName("member/csView");
		return mav;
	}
	@GetMapping("/csUpdate/{board_idx}")
	public String update(@PathVariable("board_idx")int idx) {
		return "member/csUpdate";
	}
	//Q&A게시글 수정
	@PostMapping("/csUpdate/{board_idx}") 
		public String update(CustomerVO input) {
			cs.update(input);
			return "redirect:/member/customer#qna";
		}
	//게시글 삭제
	@GetMapping("/csdelete/{board_idx}")
	public String csdelete(CustomerVO idx) {
		cs.deleteCS(idx);
		return "redirect:/member/customer#qna";
	}

	}

	
	
	

