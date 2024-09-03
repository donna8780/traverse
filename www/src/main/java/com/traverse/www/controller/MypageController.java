package com.traverse.www.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.traverse.www.service.MyPageService;
import com.traverse.www.vo.AccountsVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
public class MypageController {
   
   @Autowired
   MyPageService ms;
   
   // 마이페이지
   @GetMapping("/myPage")
   public String mypage(HttpSession session) {
  	 AccountsVO user = (AccountsVO) session.getAttribute("user");
  	 
  	 if (user == null) {
  		 return "redirect:/member/login";
  	 }
  	 
  	 return "member/myPage";
   }
   
   // 수정
   @GetMapping("/update")
   public void update() {}
   
   // 수정실행
   @PostMapping("/update")
   public String update(AccountsVO input) {
      ms.update(input);
      return "redirect:/member/logout";
   }
   
   // 삭제
   @GetMapping("/delete/{accounts_idx}")
   public String delete(@PathVariable("accounts_idx") int idx) {
  	 
  	 ms.deleteAccount(idx);
 		
 		return "redirect:/member/logout";
 	}
   
   @PostMapping("/uploadProfile")
   public String uploadProfile(@RequestParam("profileImage") MultipartFile file, HttpSession session) {
       AccountsVO user = (AccountsVO) session.getAttribute("user");

       if (user == null) {
           return "redirect:/member/login";
       }

       if (!file.isEmpty()) {
           try {
               // 기존 파일 경로 확인 및 삭제
               String oldProfile = user.getProfile();
               if (oldProfile != null && !oldProfile.isEmpty() && !oldProfile.equals("default.png")) {
                   Path oldFilePath = Paths.get("C:/spring/traverse/www/src/main/resources/static/image/profile/", oldProfile);
                   if (Files.exists(oldFilePath)) {
                       Files.delete(oldFilePath);
                       System.out.println("Old profile image deleted: " + oldFilePath.toString());
                   }
               }

               // 새 파일을 저장할 경로 설정
               String uploadDir = "C:/spring/traverse/www/src/main/resources/static/image/profile/";
               String fileName = user.getAccounts_idx() + "_" + file.getOriginalFilename();
               Path filePath = Paths.get(uploadDir, fileName);

               // 디렉토리가 존재하지 않으면 생성
               if (Files.notExists(filePath.getParent())) {
                   Files.createDirectories(filePath.getParent());
               }

               // 파일 저장
               file.transferTo(filePath.toFile());

               // 사용자의 프로필 경로 업데이트
               String profilePath = fileName;
               user.setProfile(profilePath);
               ms.updateProfile(user);

               // 세션 업데이트
               session.setAttribute("user", user);

           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       return "redirect:/member/logout";
   }



   
   
   

}
