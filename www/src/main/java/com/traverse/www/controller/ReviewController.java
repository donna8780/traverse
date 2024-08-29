package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.traverse.www.service.ReviewService;
import com.traverse.www.vo.ReviewVO;

@Controller
@RequestMapping("/member")
public class ReviewController {

    @Autowired
    private ReviewService rs;

    // 리뷰 작성
    @PostMapping("/review")
    public String addReview(ReviewVO review) {
        boolean isAdded = rs.addReview(review);
        if (!isAdded) {
            // 리뷰가 이미 있는 경우 경고 메시지와 함께 이전 페이지로 리다이렉트
            return "redirect:/member/detail/" + review.getP_idx() + "?error=duplicate";
        }
        return "redirect:/member/detail/" + review.getP_idx(); // 등록 후 상세 페이지로 리다이렉트
    }
    
    // 리뷰 수정
    @PostMapping("/review/edit")
    public String updateReview(ReviewVO review) {
        rs.updateReview(review);
        return "redirect:/member/detail/" + review.getP_idx();
    }

    // 리뷰 삭제
    @PostMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable("id") int id, @RequestParam("p_idx") int p_idx) {
        rs.deleteReview(id);
        return "redirect:/member/detail/" + p_idx;
    }
}
