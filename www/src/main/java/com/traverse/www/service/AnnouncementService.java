package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.AnnouncementDAO;
import com.traverse.www.vo.AnnouncementVO;



@Service
public class AnnouncementService {
	
	@Autowired
	private AnnouncementDAO dao;
	
	public List<AnnouncementVO> announce() {
		return dao.announce();
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
