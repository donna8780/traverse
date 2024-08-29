
package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.LikeService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.LikeVO;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

	
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

   @PostMapping("/member/like")
   public ResponseEntity<String> likePlace(@RequestBody LikeVO likeVO) {
       try {
           like.insertLike(likeVO);  // 서비스에서 데이터 삽입
           return ResponseEntity.ok("Liked");
       } catch (Exception e) {
           e.printStackTrace();  // 오류 로그를 출력합니다.
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while liking place.");
       }
   }
   @DeleteMapping("/member/like")
   public ResponseEntity<String> unlikePlace(@RequestBody LikeVO likeVO) {
       try {
           like.deleteLike(likeVO);  // 서비스에서 데이터 삭제
           return ResponseEntity.ok("Unliked");
       } catch (Exception e) {
           e.printStackTrace();  // 오류 로그를 출력합니다.
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while unliking place.");
       }
   }


   
}
