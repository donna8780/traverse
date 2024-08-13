package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.MapAPIVO;

@Mapper
public interface MapAPIDAO {

	@Select("select * from like_place")
	List<MapAPIVO> selectAll();

}
