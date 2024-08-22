package com.traverse.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.AnnouncementService;
import com.traverse.www.service.CustomerService;
import com.traverse.www.service.ReplyService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.CustomerVO;
import com.traverse.www.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private AnnouncementService as;
	
	@Autowired
	private ReplyService rs;
	
	

	/*공지사항으로 이동하는 코드*/
	@GetMapping("/customer")
	/*@RequestParam은 URL에 포함된 파라미터 값을 서버에서 받아올 때 사용*/
	public ModelAndView csboard(@RequestParam(value = "idx", required = false) Integer idx) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> announceMap = as.announce(idx);

		mav.addObject("pg", announceMap.get("pg"));
		mav.addObject("announce", announceMap.get("list"));
		
		Map<String, Object> qnaMap = cs.cstest(idx);
		mav.addObject("qnapg", qnaMap.get("pg"));
		mav.addObject("qna", qnaMap.get("list"));

		
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
		mav.addObject("replys", rs.getReplys(idx));
		mav.setViewName("member/csView");
		return mav;
	}
	
	// QnA 댓글 작성
	@PostMapping("/csView/{c_idx}")
	public String writeReply(ReplyVO input) {
		rs.addReply(input);
		
		return "redirect:/member/csView/" + input.getC_idx();
	}	
	
	// QnA 댓글 삭제
	@GetMapping("/csView/delete")
	public String repdelete(@RequestParam(value = "rep_idx", required = false) Integer rep_idx, 
	                        @RequestParam(value = "c_idx", required = false) Integer c_idx) {
	    System.out.println(rep_idx);
	    rs.deleteRep(rep_idx);
	    
	    // 댓글이 속한 Q&A 게시글로 리다이렉트
	    return "redirect:/member/csView/" + c_idx;
	}
	
	@PostMapping("/repUpdate")
	public String repUpdate(ReplyVO input) {
	    rs.updateReply(input);
	    System.out.println(input.getC_idx());
	     return "redirect:/member/csView/" + input.getC_idx();
	}

	// QnA 게시글 수정
	@GetMapping("/csUpdate/{board_idx}")
	public String update(@PathVariable("board_idx")int idx) {
		return "member/csUpdate";
	}
	//Q&A게시글 수정 실행
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

	

	

