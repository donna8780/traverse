package com.traverse.www.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.DetailService;
import com.traverse.www.service.ReviewService;
import com.traverse.www.service.TestService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class DetailController {
    
    @Autowired
    private DetailService ds;
    
    @Autowired
    private ReviewService rs;
    
    @Autowired
    private TestService ts;

    // 특정 관광지의 상세페이지
    @GetMapping("/detail/{idx}")
    
    public ModelAndView detail(@PathVariable("idx") int idx, 
											    	   @RequestParam("contenttypeid")int contenttypeid,
											    		 @RequestParam("contentid")int contentid,
											    		 HttpSession session) {
    		AccountsVO user = (AccountsVO) session.getAttribute("user");
    		ModelAndView mav = new ModelAndView();
    		
    		HashMap<String, String> place = ts.getPlace(contenttypeid,contentid);
        mav.addObject("place", place);
        
        
        HashMap<String, String> placeDetails = ts.getPlaceDetails(contenttypeid,contentid);
        mav.addObject("detail", placeDetails);

        
        mav.addObject("detailpage", ds.getDetailById(idx));
        mav.addObject("reviews", rs.getReviewsByPlaceId(idx)); // 리뷰 데이터 추가
    		
        if (user == null) {
    			mav.setViewName("redirect:/member/login");
				}else {
	        mav.setViewName("member/detail");  // detail.html 뷰로 연결 
				}
    		
    			return mav;
    }
    
}
