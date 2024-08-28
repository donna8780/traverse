package com.traverse.www.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.DetailVO;

@Mapper
public interface DetailDAO {

    // 특정 idx로 상세 정보 가져오기
    @Select("select * from tourist_p_idx where idx = #{idx}")
    DetailVO findById(int idx);
}
