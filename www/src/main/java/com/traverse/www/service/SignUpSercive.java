package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.SignUpDAO;
import com.traverse.www.vo.AccountsVO;
@Service
public class SignUpSercive {
	
	@Autowired
	private SignUpDAO dao;

	public int addAccount(AccountsVO input) {
		return dao.insert(input);
		
	}

	public String checkUserID(String userid) {
		if (userid == "donna8780") {
			
			return "중복된 아이디 입니다.";
		}
		
		return dao.select(userid);
		
	}




}
