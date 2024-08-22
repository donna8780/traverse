package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.PlaceVO;

@Mapper
public interface AccommodationDAO {
	@Select("select * from accommodation order by areacode")
	List<PlaceVO> selectAll();
	
  @Select("select * from accommodation where title LIKE CONCAT('%', #{title}, '%')")
  List<PlaceVO> selectByTitle(String title);
	
}
