package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.PlaceVO;
import com.traverse.www.vo.SelPlaceVO;



@Mapper
public interface AccountsDAO {

	@Select("select * from accounts")
	List<AccountsVO> test();

	@Insert("insert into sel_place(a_idx, areaCode) values(#{a_idx}, #{areaCode})")
	int sel_areaCode(SelPlaceVO vo);
	
	@Delete("delete from sel_place where a_idx = #{a_idx}")
	int delete(int a_idx);

	@Update("update sel_place set duration = #{duration} where a_idx = #{a_idx}")
	int sel_duration(SelPlaceVO vo);

	@Update("update sel_place "
			+ "set sigunguCode1 = #{sigunguCode1}, sigunguCode2 = #{sigunguCode2}, sigunguCode3 = #{sigunguCode3} "
			+ "where a_idx = #{a_idx}")
	int sel_sigunguCode(SelPlaceVO vo);

	@Select("select * from sel_place where a_idx = #{a_idx}")
	SelPlaceVO getSelPlace(int a_idx);
	
	@Select("select * from place "
			+ "WHERE (#{areaCode} = 39 AND areacode = #{areaCode}) "
			+ "OR (#{areaCode} >= 30 AND (areacode = #{areaCode} AND sigungucode IN (#{sigunguCode1}, #{sigunguCode2}, #{sigunguCode3}))) "
			+ "OR (#{areaCode} < 30 AND areacode = #{areaCode}) "
			+ "order by rand() limit #{duration}")
	List<PlaceVO> getPlaces(SelPlaceVO result);
	
	@Select("select * from place "
			+ "WHERE ((#{result.areaCode} = 39 AND areacode = #{result.areaCode}) "
			+ "OR (#{result.areaCode} >= 30 AND (areacode = #{result.areaCode} AND sigungucode IN (#{result.sigunguCode1}, #{result.sigunguCode2}, #{result.sigunguCode3}))) "
			+ "OR (#{result.areaCode} < 30 AND areacode = #{result.areaCode})) and contenttypeid = #{type} "
			+ "order by rand() limit #{result.duration}")
	List<PlaceVO> getPlacesother(@Param("result")SelPlaceVO result,@Param("type")int type);

}
  