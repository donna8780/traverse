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
		return dao.select(userid);
	}
	public String checkUserNick(String nick) {
		return dao.select_nick(nick);
	}
	public String checkUserPhone(String phone) {
		return dao.select_phone(phone);
	}
	




}
