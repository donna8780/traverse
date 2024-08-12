package com.traverse.www.controller;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traverse.www.service.SignUpSercive;
import com.traverse.www.vo.AccountsVO;

@Controller
@RequestMapping("/member")
public class SignUpController {
	
	@Autowired
	private SignUpSercive ss;
	
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

	@GetMapping("/checkUserid")
	@ResponseBody
	public Map<String, Object> checkUserid(@RequestParam(name = "userid") String userid) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(userid);
		
		result.put("name", "백은");
		
		//userid값 넘겨주기?
		ss.checkUserID(userid);
		
		// service -> dao -> sql 구문 실행
		// select userid from account where userid = "itbank";
		return result;
	}
}				