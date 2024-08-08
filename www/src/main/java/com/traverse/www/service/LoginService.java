package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.LoginDAO;
import com.traverse.www.vo.AccountsVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;

	public AccountsVO getAccounts(AccountsVO input) {
		
		return dao.selectOne(input);
	}

	public AccountsVO findID(AccountsVO input) {
		
		return dao.findID(input);
	}

}
