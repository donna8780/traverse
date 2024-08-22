package com.traverse.www.model;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TravelplanDAO {
	
	@Insert("insert into travelplan(p_idx,a_idx,areaCode,sigunguCode1,sigunguCode2,sigunguCode3,duration) values(#{p_idx},#{a_idx},#{areaCode},#{sigunguCode1},#{sigunguCode2},#{sigunguCode3},#{duration})")
	int insert(@Param("p_idx") int p_idx, 
      @Param("a_idx") int a_idx, 
      @Param("areaCode") int areaCode, 
      @Param("sigunguCode1") int sigunguCode1,
      @Param("sigunguCode2") int sigunguCode2, 
      @Param("sigunguCode3") int sigunguCode3, 
      @Param("duration") int duration);
	
	

}
