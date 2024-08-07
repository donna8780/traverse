package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.AccountsDAO;
import com.traverse.www.vo.AccountsVO;

@Service
public class MainService {
	
	@Autowired
	private AccountsDAO dao;

	public List<AccountsVO> test() {
		return dao.test();
	}

}
