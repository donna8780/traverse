package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.DetailService;
import com.traverse.www.service.ReviewService;


@Controller
@RequestMapping("/member")
public class DetailController {
    
    @Autowired
    private DetailService ds;
    
    @Autowired
    private ReviewService rs;

    // 특정 관광지의 상세페이지
    @GetMapping("/detail/{idx}")
    public ModelAndView detail(@PathVariable("idx") int idx) {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("detail", ds.getDetailById(idx));
        mav.addObject("reviews", rs.getReviewsByPlaceId(idx)); // 리뷰 데이터 추가
        mav.setViewName("member/detail");  // detail.html 뷰로 연결
        
        return mav;
    }
    
}
