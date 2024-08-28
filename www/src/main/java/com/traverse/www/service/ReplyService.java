package com.traverse.www.service;

import java.util.List;

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


	public List<ReplyVO> getReplys(int idx) {
		
		return dao.selectAll(idx);
	}


	public int deleteRep(Integer idx) {
		return dao.delete(idx);
	}

	public int updateReply(ReplyVO input) {
    return dao.update(input);
}



}
