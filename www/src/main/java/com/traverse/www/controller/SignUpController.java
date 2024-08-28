package com.traverse.www.controller;

import java.security.NoSuchAlgorithmException;
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
	public String signUp(AccountsVO input) throws NoSuchAlgorithmException {
		
		ss.addAccount(input);
		return "redirect:/";
	}
	/*서비스의 checkUserid메서드가 이 경로로 들어오는 HTTP GET요청을 처리
	사용자가 웹 브라우저에서 URL로 GET요청을 보내면 이 메서드 호출 
	*/
	@GetMapping("/checkUserid")
	@ResponseBody /*반환값을 JSON또는XML형식으로 변환하여 HTTP응답으로 전송*/
	/*결과를 저장할 맵(키,값)객체를 생성하여 사용자가 입력한 아이디에 대한 메세지를 맵에 저장*/
	public Map<String, Object> checkUserID(@RequestParam(name = "userid") String userid) {
		Map<String, Object> result = new HashMap<>();
		/*전달된 userid가 db에 존재하는지 확인*/
		String check = ss.checkUserID(userid);	
		//기본 메세지 설정
		String msg = check+"는 중복된 아이디 입니다";
		
		if(check == null) {//체크값이 널이라면 아이디 중복x
			msg = "사용 가능한 아이디 입니다.";
		}
		//msg값을 result맵에 넣고 나중에 json형식으로 변환되어 클라이언트에 전달
		result.put("name", msg);
		//result 맵 반환
		//@ResponseBody로 인해 json형식으로 변환되어 전달
		return result;	

	}
	//닉네임 중복
	@GetMapping("/checkUserNick")
	@ResponseBody
	public Map<String, Object> checkUserNick(@RequestParam(name = "userNick")String userNick)
	{
		Map<String, Object> result = new HashMap<>();
		String check_nick = ss.checkUserNick(userNick);
		
		String msg = check_nick+"는 중복된 닉네임 입니다";
		if(check_nick == null) {
			msg = "사용 가능한 닉네임입니다.";
		}
		result.put("nick", msg);
		return result;
	}
	//전화번호 중복
	@GetMapping("/checkUserPhone")
	@ResponseBody
	public Map<String, Object> checkUserPhone(@RequestParam(name = "phone")String phone)
	{
		Map<String, Object> result = new HashMap<>();
		String check_phone = ss.checkUserPhone(phone);
		String msg = check_phone+"는 중복된 전화번호 입니다";
		if(check_phone == null) {
			msg = "사용 가능한 전화번호입니다.";
		}
		result.put("phone", msg);
		return result;
	}
	
	
	
}				