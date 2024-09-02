package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.AreaVO;
import com.traverse.www.vo.PlaceVO;

@Mapper
public interface AccommodationDAO {
	@Select("select * from area_view order by areaCode")
	List<PlaceVO> selectAll();
	
  @Select("select * from area_view where title LIKE CONCAT('%', #{title}, '%') OR ADDR1 LIKE CONCAT('%', #{addr1}, '%')")
  List<PlaceVO> selectByTitle(String title);
  
  @Select("select * from area_view where areaCode = #{areaCode}")
  List<PlaceVO> selectByAreaCode(String areaCode);
	
  @Select("SELECT DISTINCT areaCode, areaName FROM area_view ORDER BY areaCode")
  List<AreaVO> selectAllAreaCodes();
}
