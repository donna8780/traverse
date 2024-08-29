package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.TravelplanDAO;
import com.traverse.www.vo.PlaceVO;
import com.traverse.www.vo.TravelplanVO;


@Service
public class TravelplanService {
	@Autowired
	private TravelplanDAO dao;

	public int planadd(int p_idx, int a_idx, int areaCode, int sigunguCode1,
			int duration, String seldate,int day) {
		
		return dao.insert(p_idx,a_idx,areaCode,sigunguCode1,duration,seldate,day);
	}

	public List<TravelplanVO> getPlace(int accounts_idx) {
		return dao.getPlace(accounts_idx);
	}

	public List<PlaceVO> getPlanplace(int user_idx, String seldate) {

		return dao.getPlanplace(user_idx,seldate);
	}

	public List<PlaceVO> getdayplan(int user_idx, int day, String seldate) {
		
		return dao.getdayplan(user_idx,day,seldate);
	}
	

}
