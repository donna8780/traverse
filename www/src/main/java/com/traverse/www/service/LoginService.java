package com.traverse.www.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.exception.LoginException;
import com.traverse.www.model.LoginDAO;
import com.traverse.www.vo.AccountsVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;

	public AccountsVO getAccounts(AccountsVO input) throws LoginException {
		input = dao.selectOne(input);
		
		if(input == null) {
			String msg = "일치하는 정보가 없습니다.\n ID 또는 PW를 다시 확인해 주세요";
			throw new LoginException(msg);
		}
		
		return input;
	}

	public String findID(AccountsVO input) {
		return dao.findID(input);
	}

	public int findPW(AccountsVO input) throws LoginException {
		
		input = dao.findPW(input);
		
		
		 if(input == null) { 
			 String msg = "일치하는 정보가 존재하지 않습니다"; 
			 throw new LoginException(msg);
			 }
		
		return input.getAccounts_idx();
	}

	public int newPW(AccountsVO input) {
		
		return dao.updatenewPW(input);
	}

}
