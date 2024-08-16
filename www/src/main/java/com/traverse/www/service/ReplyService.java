package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.ReplyDAO;
import com.traverse.www.vo.ReplyVO;

@Service
public class ReplyService {

	@Autowired
	private ReplyDAO dao;
	

	public int addReply(ReplyVO input) {
		
		return dao.insert(input);
	}

}
