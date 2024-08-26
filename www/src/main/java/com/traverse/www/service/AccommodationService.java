package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.AccommodationDAO;
import com.traverse.www.vo.PlaceVO;

@Service
public class AccommodationService {
	
	@Autowired
	private AccommodationDAO dao;

	public List<PlaceVO> getaccom() {
		return dao.selectAll();
	}
	
  public List<PlaceVO> searchByTitle(String title) {
    return dao.selectByTitle(title);
}

}
