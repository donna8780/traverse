package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.DetailService;
import com.traverse.www.service.ReplyService;
import com.traverse.www.vo.ReplyVO;

@Controller
@RequestMapping("/member")
public class DetailController {
	
	@Autowired
	private DetailService ds;
	
	@Autowired ReplyService rs;
	
	//상세페이지
	@GetMapping("/detail")
	public ModelAndView detail() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detail", ds.showdetail());

		return mav;
		
	}
	
	// 상세 페이지 댓글 작성
	@PostMapping("/detail")
	public String writeReply(ReplyVO input) {
		rs.addReply(input);
		
		return "redirect:/member/detail" + input.getRep_idx();
	}


}
