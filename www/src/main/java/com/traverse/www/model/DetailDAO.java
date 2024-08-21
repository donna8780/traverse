package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.DetailVO;

@Mapper
public interface DetailDAO {

	@Select("select * from gangwon where idx = 5")
	List<DetailVO> show();

	
}
