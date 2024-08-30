package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.MyPageDAO;
import com.traverse.www.vo.AccountsVO;


@Service
public class MyPageService {
   
   @Autowired
   MyPageDAO dao;

   public int update(AccountsVO input) {
      return dao.update(input);
   }

	public int deleteAccount(int idx) {
		
		return dao.delete(idx);
	}
	
  public int updateProfile(AccountsVO user) {
    return dao.updateProfile(user);
}
	

}
