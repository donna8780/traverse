package com.traverse.www.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.LikeVO;




@Mapper
public interface LikeDAO {
   @Select("select * from like_view where nick = #{usernick}")
   List<LikeVO> selectAll(String usernick);
   
   @Delete("delete from like_place where like_idx=#{like_idx}")
   String delete(LikeVO idx);

   @Delete("delete from like_place where like_idx=#{likeIdx}")
	int likeDel(int likeIdx);

   @Insert("INSERT INTO like_place (a_idx, title, addr1, firstimage, mapx, mapy,p_idx,contenttypeid,contentid) " +
       "VALUES (#{a_idx}, #{title}, #{addr1}, #{firstimage}, #{mapx}, #{mapy}, #{p_idx},#{contenttypeid},#{contentid})")
   void insert(LikeVO likeVO);
   
   @Delete("DELETE FROM like_place WHERE a_idx = #{a_idx} AND title = #{title}")
   void deletelike(LikeVO likeVO);
   
  @Update("update like_place set islike=1 where p_idx=#{idx} and a_idx=#{a_idx}")
	void likeupdate(@Param("idx")int idx, @Param("a_idx") int a_idx);
  
  @Update("update like_place set islike=0 where p_idx=#{idx} and a_idx=#{a_idx}")
	void likeupdatede(@Param("idx")int idx, @Param("a_idx") int a_idx);
}
