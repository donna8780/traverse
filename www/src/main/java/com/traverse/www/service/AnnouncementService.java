package com.traverse.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.component.Paging;
import com.traverse.www.model.AnnouncementDAO;
import com.traverse.www.vo.AnnouncementVO;



@Service
public class AnnouncementService {
	
	@Autowired
	private AnnouncementDAO dao;
	
	public Map<String, Object> announce(Integer idx) {
		
		if(idx == null) {idx = 1;}
		Paging pg = new Paging(idx,dao.totalBoard());
		List<AnnouncementVO> list = dao.announce(pg);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pg", pg);
		map.put("list", list);
	
		return map;
	}

	public int writeAnnouncement(AnnouncementVO input) {
		
		return dao.insert(input);
	}

	public AnnouncementVO getBoardOne(int idx) {
		
		return dao.selectOne(idx);
	}

	public int deleteAccount(AnnouncementVO idx) {
		
		return dao.delete(idx);
	}

	public int update(AnnouncementVO input) {
		return dao.update(input);
		
	}

}
