package com.traverse.www.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.DetailVO;
import com.traverse.www.vo.LikeVO;
import com.traverse.www.vo.PlaceVO;


@Mapper
public interface DetailDAO {

    // 특정 idx로 상세 정보 가져오기
    @Select("select * from place where idx = #{idx}")
    PlaceVO findById(int idx);
    
    @Select("select islike from like_place where a_idx=#{accounts_idx} and p_idx=#{idx}")
    PlaceVO getIslike(@Param("accounts_idx")int accounts_idx, @Param("idx")int idx);
}
