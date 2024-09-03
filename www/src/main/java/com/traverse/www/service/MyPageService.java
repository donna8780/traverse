package com.traverse.www.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.component.Sha_512Hash;
import com.traverse.www.model.MyPageDAO;
import com.traverse.www.vo.AccountsVO;


@Service
public class MyPageService {
   
   @Autowired
   MyPageDAO dao;
   @Autowired
   private Sha_512Hash hash; 

   public int update(AccountsVO input) throws NoSuchAlgorithmException {
  	 String userpw = input.getUserpw(); 
     String hashpw = hash.getHash(userpw); 
     input.setUserpw(hashpw);
  	 
      return dao.update(input);
   }

	public int deleteAccount(int idx) {
		
		return dao.delete(idx);
	}
	
  public int updateProfile(AccountsVO user) {
    return dao.updateProfile(user);
}
	

}
