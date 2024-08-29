package com.traverse.www.model;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.PlaceVO;
import com.traverse.www.vo.TravelplanVO;




@Mapper
public interface TravelplanDAO {
	
	@Insert("insert into travelplan(p_idx,a_idx,areaCode,sigunguCode1,duration,seldate,day) values(#{p_idx},#{a_idx},#{areaCode},#{sigunguCode1},#{duration},#{seldate},#{day})")
	int insert(@Param("p_idx") int p_idx, 
      @Param("a_idx") int a_idx, 
      @Param("areaCode") int areaCode, 
      @Param("sigunguCode1") int sigunguCode1,
      @Param("duration") int duration,
      @Param("seldate") String seldate,
      @Param("day") int day);

	@Select("select distinct * from area_a_idx where a_idx = #{accounts_idx}")
	List<TravelplanVO> getPlace(int accounts_idx);
	
	@Select("select * from place_a_idx where a_idx = #{user_idx} and seldate = #{seldate}")
	List<PlaceVO> getPlanplace(@Param("user_idx") int user_idx, @Param("seldate") String seldate);

	@Select("select * from place_a_idx where a_idx = #{user_idx} and seldate = #{seldate} and day = #{day}")
	List<PlaceVO> getdayplan(@Param("user_idx") int user_idx, @Param("day") int day, @Param("seldate") String seldate);
	
}
