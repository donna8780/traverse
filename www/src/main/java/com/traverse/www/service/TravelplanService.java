package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.TravelplanDAO;

@Service
public class TravelplanService {
	@Autowired
	private TravelplanDAO dao;

	public int planadd(int p_idx, int a_idx, int areaCode, int sigunguCode1,
			int sigunguCode2, int sigunguCode3, int duration) {
		
		return dao.insert(p_idx,a_idx,areaCode,sigunguCode1,sigunguCode2,sigunguCode3,duration);
	}

	

}
