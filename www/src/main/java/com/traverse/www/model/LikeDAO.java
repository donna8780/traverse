package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.traverse.www.vo.LikeVO;




@Mapper
public interface LikeDAO {
   @Select("select * from like_view where nick = #{usernick}")
   List<LikeVO> selectAll(String usernick);
   
   @Delete("delete from like_place where like_idx=#{like_idx}")
   String delete(LikeVO idx);

   @Delete("delete from like_place where like_idx=#{likeIdx}")
	int likeDel(int likeIdx);

   @Insert("INSERT INTO like_place (a_idx, title, addr1, firstimage, mapx, mapy,p_idx) " +
       "VALUES (#{a_idx}, #{title}, #{addr1}, #{firstimage}, #{mapx}, #{mapy}, #{p_idx})")
   void insert(LikeVO likeVO);
}
