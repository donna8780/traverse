package com.traverse.www.service;


import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.component.Sha_512Hash;
import com.traverse.www.exception.LoginException;
import com.traverse.www.model.LoginDAO;
import com.traverse.www.vo.AccountsVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	@Autowired
  private Sha_512Hash hash; 

	public AccountsVO getAccounts(AccountsVO input) throws LoginException, NoSuchAlgorithmException {
		String userpw = input.getUserpw(); 
    String hashpw = hash.getHash(userpw); 
    input.setUserpw(hashpw);
		
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

	public int newPW(AccountsVO input) throws NoSuchAlgorithmException {
		String userpw = input.getUserpw(); // 원본 비밀번호
    String hashpw = hash.getHash(userpw); // 해시 처리된 비밀번호
    input.setUserpw(hashpw); // 해시 처리된 비밀번호를 객체에 설정
		
		
		return dao.updatenewPW(input);
	}

}
