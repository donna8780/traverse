package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.traverse.www.model.ReviewDAO;
import com.traverse.www.vo.ReviewVO;

import java.util.List;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewDAO dao;

    // 특정 p_idx로 리뷰 리스트 가져오기
    public List<ReviewVO> getReviewsByPlaceId(int p_idx) {
        return dao.findByPlaceId(p_idx);
    }

 // 리뷰 추가하기 (이미 있는지 확인 후 추가)
    public boolean addReview(ReviewVO review) {
        int existingReviewCount = dao.countByUserAndPlaceId(review.getA_idx(), review.getP_idx());
        if (existingReviewCount > 0) {
            return false; // 이미 리뷰가 있음
        }
        dao.insertReview(review);
        return true; // 리뷰 추가 성공
    }
    
    // 리뷰 수정
    public void updateReview(ReviewVO review) {
        dao.updateReview(review);
    }

    // 리뷰 삭제
    public void deleteReview(int id) {
        dao.deleteReviewById(id);
    }
}
