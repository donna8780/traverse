package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.MapAPIDAO;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.LikeVO;
import com.traverse.www.vo.MapAPIVO;

@Service
public class MapAPIService {
	
	@Autowired
	private MapAPIDAO dao;

	public List<MapAPIVO> selectAll() {
		return dao.selectAll();
	}

}
