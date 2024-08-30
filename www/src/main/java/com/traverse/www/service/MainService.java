package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.AccountsDAO;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.PlaceVO;
import com.traverse.www.vo.SelPlaceVO;



@Service
public class MainService {
	
	@Autowired
	private AccountsDAO dao;

	public List<AccountsVO> test() {
		return dao.test();
	}
	
  public int sel_areaCode(int areaCode, int a_idx) {
      SelPlaceVO vo = new SelPlaceVO();
      vo.setAreaCode(areaCode);
      vo.setA_idx(a_idx);
      return dao.sel_areaCode(vo);
  }

	public int delete(int a_idx) {
		return dao.delete(a_idx);
	}

	public int sel_duration(int duration, int a_idx) {
		SelPlaceVO vo = new SelPlaceVO();
		vo.setDuration(duration);
		vo.setA_idx(a_idx);
		return dao.sel_duration(vo);
	}

	public int sel_sigunguCode(int a_idx, int sigunguCode1, int sigunguCode2, int sigunguCode3) {
		SelPlaceVO vo = new SelPlaceVO();
		vo.setA_idx(a_idx);
		vo.setSigunguCode1(sigunguCode1);
		vo.setSigunguCode2(sigunguCode2);
		vo.setSigunguCode3(sigunguCode3);
		return dao.sel_sigunguCode(vo);
	}

	public SelPlaceVO getSelPlace(int a_idx) {
		return dao.getSelPlace(a_idx);
	}

	public List<PlaceVO> getPlaces(SelPlaceVO result) {
		int d = result.getDuration();
		result.setDuration(d * 5);
		
		return dao.getPlaces(result);
	}

}
