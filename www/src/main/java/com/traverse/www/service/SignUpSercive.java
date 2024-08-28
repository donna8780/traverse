package com.traverse.www.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.component.Sha_512Hash;
import com.traverse.www.model.SignUpDAO;
import com.traverse.www.vo.AccountsVO;
@Service
public class SignUpSercive {
	
	@Autowired
	private SignUpDAO dao;

	@Autowired
	private Sha_512Hash hash;
	//회원가입
	public int addAccount(AccountsVO input) throws NoSuchAlgorithmException {
		
		// DB에 넘기기 전에 해시 처리할거임 (= 상세 로직)
				String userpw = input.getUserpw();
				String hashpw = hash.getHash(userpw);
				
				input.setUserpw(hashpw);
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
