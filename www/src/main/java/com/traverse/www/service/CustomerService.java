package com.traverse.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.component.Paging;
import com.traverse.www.model.CsboardDAO;
import com.traverse.www.vo.CustomerVO;

@Service
public class CustomerService {

	@Autowired
	private CsboardDAO dao;
	//q&a 게시판을 띄운다.
	public Map<String, Object> cstest(Integer idx) {
		
		//페이지값이 널이면 한 페이지 보여준다.(idx = 1)
		if(idx == null) {idx =1;}
		Paging pg = new Paging(idx, dao.totalQna());
		List<CustomerVO> list = dao.cstest(pg);
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("qnapg", pg);
		map.put("list", list);
		
		return map;
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