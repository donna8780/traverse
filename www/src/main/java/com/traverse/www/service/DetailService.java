package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.DetailDAO;
import com.traverse.www.vo.DetailVO;

@Service
public class DetailService {
	
	@Autowired
	private DetailDAO dao;

	public List<DetailVO> showdetail() {
		
		return dao.show();
	}
	
	

}
