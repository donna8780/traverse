package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.CsboardDAO;
import com.traverse.www.vo.CustomerVO;

@Service
public class CustomerService {

	@Autowired
	private CsboardDAO dao;
	public List<CustomerVO> cstest() {
		
		return dao.cstest();
	}
	public int cusWrite(CustomerVO input) {
		return dao.insert(input);
		
	}
	public CustomerVO getCsBoardOne(int idx) {
		
		return dao.selectOne(idx);
	}
	public int update(CustomerVO input) {
		return dao.update(input);
		
	}
	public int deleteCS(CustomerVO idx) {
		return dao.delete(idx);
		
	}

}