package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.AccountsVO;
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

}
  