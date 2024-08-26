
package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.LikeService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.LikeVO;

import jakarta.servlet.http.HttpSession;
	
@Controller
public class LikeController {
   
   @Autowired
   private LikeService like;

   //main
   @GetMapping("/member/like")
   public ModelAndView like(HttpSession session) {
  	 
      ModelAndView mav = new ModelAndView();
      
      
      
      
      if(session.getAttribute("user") == null) {
      	mav.setViewName("redirect:/member/login");
      	return mav;
      }
      else {
      	
      	AccountsVO user = (AccountsVO) session.getAttribute("user");
        
        String usernick = user.getNick();
        mav.addObject("mapAPI", like.getboards(usernick));
        
        
      	return mav;
      }
   
      
   }
   
   //delete
   @GetMapping("/member/like_delete/{like_idx}")
   public String delete(LikeVO idx) {
  	 
  	 like.delete(idx);
  	 
   	return "redirect:/member/like";
   	
   }
   
   @GetMapping("/member/likeDel/{likeIdx}")
   public String likeDel(@PathVariable("likeIdx") int likeIdx) {
  	 
  	 like.likeDel(likeIdx);
  	 
  	 return "redirect:/member/like";
   }


}
