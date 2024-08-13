package com.traverse.www.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.CsboardDAO.CsboardDAO;
import com.traverse.www.vo.CustomerVO;

@Service
public class CustomerService {

	@Autowired
	private CsboardDAO dao;
	public List<CustomerVO> cstest() {
		
		return dao.cstest();
	}

}
