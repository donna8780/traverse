package com.traverse.www.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.traverse.www.vo.ReviewVO;

import java.util.List;

@Mapper
public interface ReviewDAO {

    // 특정 p_idx로 리뷰 가져오기
    @Select("SELECT * FROM detail_view WHERE p_idx = #{p_idx}")
    List<ReviewVO> findByPlaceId(int p_idx);
    
    // 특정 유저가 특정 p_idx에 리뷰를 달았는지 확인
    @Select("SELECT COUNT(*) FROM dep_reply WHERE a_idx = #{a_idx} AND p_idx = #{p_idx}")
    int countByUserAndPlaceId(@Param("a_idx") int a_idx, @Param("p_idx") int p_idx);

    // 리뷰 추가하기
    @Insert("INSERT INTO dep_reply (a_idx, p_idx, contents, rating) VALUES (#{a_idx}, #{p_idx}, #{contents}, #{rating})")
    void insertReview(ReviewVO review);
    
    // 리뷰 수정
    @Update("UPDATE dep_reply SET contents = #{contents}, rating = #{rating} WHERE drep_idx = #{drep_idx}")
    void updateReview(ReviewVO review);

    // 리뷰 삭제
    @Delete("DELETE FROM dep_reply WHERE drep_idx = #{drep_idx}")
    void deleteReviewById(int id);
}
