package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.signUpDAO;
import com.traverse.www.vo.AccountsVO;
@Service
public class signUpSercive {
	
	@Autowired
	private signUpDAO dao;

	public int addAccount(AccountsVO input) {
		
	
		return dao.insert(input);
		
	}

}
