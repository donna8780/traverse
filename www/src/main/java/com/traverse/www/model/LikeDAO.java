package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.LikeVO;




@Mapper
public interface LikeDAO {
   @Select("select * from like_view where nick = #{usernick}")
   List<LikeVO> selectAll(String usernick);

}
