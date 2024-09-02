package com.traverse.www.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.TraverserStoryService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.TraverserStoryVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class TraverserStoryController {

    @Autowired
    private TraverserStoryService tss;

    
    @GetMapping("/place/traverserStory")
    public ModelAndView traverserStory() {
        ModelAndView mav = new ModelAndView();
        
        // 게시글 목록을 가져오기
        List<TraverserStoryVO> stories = tss.getAllStories();
        mav.addObject("stories", stories);
        mav.setViewName("/place/traverserStory");
        
        List<TraverserStoryVO> randomItems = tss.getRand();
      
        
     // 각각의 행을 변수에 저장
        TraverserStoryVO rand1 = randomItems.get(0);
        TraverserStoryVO rand2 = randomItems.get(1);
        TraverserStoryVO rand3 = randomItems.get(2);
        TraverserStoryVO rand4 = randomItems.get(3);
        
     // 각각의 프로필 이미지 경로를 사용 가능
        String profile1 = rand1.getProfile();
        String profile2 = rand2.getProfile();
        String profile3 = rand3.getProfile();
        String profile4 = rand4.getProfile();
        
       
        // 날짜가 "yyyy-MM-dd" 형식의 문자열이라고 가정합니다.
        String selDateString1 = rand1.getSeldate(); // "2024-07-03"
        String endDateString1 = rand1.getEnddate(); // "2024-07-05"

        // 문자열을 LocalDate로 변환 (기본 ISO_LOCAL_DATE 형식 사용)
        LocalDate selDate1 = LocalDate.parse(selDateString1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate1 = LocalDate.parse(endDateString1, DateTimeFormatter.ISO_LOCAL_DATE);

        // 날짜 사이의 일수 계산
        long daysBetween1 = ChronoUnit.DAYS.between(selDate1, endDate1) + 1;
        

     // 날짜가 "yyyy-MM-dd" 형식의 문자열이라고 가정합니다.
        String selDateString2 = rand2.getSeldate(); // "2024-07-03"
        String endDateString2 = rand2.getEnddate(); // "2024-07-05"
        

        // 문자열을 LocalDate로 변환 (기본 ISO_LOCAL_DATE 형식 사용)
        LocalDate selDate2 = LocalDate.parse(selDateString2, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate2 = LocalDate.parse(endDateString2, DateTimeFormatter.ISO_LOCAL_DATE);

        // 날짜 사이의 일수 계산
        long daysBetween2 = ChronoUnit.DAYS.between(selDate2, endDate2) + 1;

     // 날짜가 "yyyy-MM-dd" 형식의 문자열이라고 가정합니다.
        String selDateString3 = rand3.getSeldate(); // "2024-07-03"
        String endDateString3 = rand3.getEnddate(); // "2024-07-05"

        // 문자열을 LocalDate로 변환 (기본 ISO_LOCAL_DATE 형식 사용)
        LocalDate selDate3 = LocalDate.parse(selDateString3, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate3 = LocalDate.parse(endDateString3, DateTimeFormatter.ISO_LOCAL_DATE);

        // 날짜 사이의 일수 계산
        long daysBetween3 = ChronoUnit.DAYS.between(selDate3, endDate3) + 1;

     // 날짜가 "yyyy-MM-dd" 형식의 문자열이라고 가정합니다.
        String selDateString4 = rand4.getSeldate(); // "2024-07-03"
        String endDateString4 = rand4.getEnddate(); // "2024-07-05"

        // 문자열을 LocalDate로 변환 (기본 ISO_LOCAL_DATE 형식 사용)
        LocalDate selDate4 = LocalDate.parse(selDateString4, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate4 = LocalDate.parse(endDateString4, DateTimeFormatter.ISO_LOCAL_DATE);

        // 날짜 사이의 일수 계산
        long daysBetween4 = ChronoUnit.DAYS.between(selDate4, endDate4) + 1;

        // 각각의 계산된 일수를 뷰에 전달
        mav.addObject("daysBetween1", daysBetween1);
        mav.addObject("daysBetween2", daysBetween2);
        mav.addObject("daysBetween3", daysBetween3);
        mav.addObject("daysBetween4", daysBetween4);
        
        
        mav.addObject("rand1", rand1);
        mav.addObject("rand2", rand2);
        mav.addObject("rand3", rand3);
        mav.addObject("rand4", rand4);

        return mav;
    }

    //requestParam으로 값을 받아서 "search" 받는다. 검색어 입력
    @PostMapping("/place/traverserStory")
    //사용자가 입력한 검색어(search)를 요청 파라미터로 받아옴
    //이 검색어는 이후 데이터베이스에서 검색 결과를 찾는 데 사용
    public ModelAndView traverserStory(@RequestParam("search") String search) {
        ModelAndView mav = new ModelAndView();
    //사용자가 입력한 검색어를 바탕으로 검색 결과를 찾아 result라는 이름으로 모델에 추가
        mav.addObject("result", tss.resultSearch(search));
    // 검색어 자체도 모델에 추가되어, 검색어가 다시 뷰에서 표시
        mav.addObject("search", search);
    //검색 결과를 표시할 뷰를 설정
        mav.setViewName("/place/tsResult");

        return mav;
    }

    @GetMapping("/place/reviews")
    public void reviews() {}

    @GetMapping("/place/story_write") // 글쓰기
    public String story_write(HttpSession session) {

        AccountsVO user = (AccountsVO) session.getAttribute("user");

        if (user == null) {
            return "redirect:/member/login";
        }

        return "/place/story_write";
    }

    // 글쓰기 실행
    @PostMapping("/place/story_write")
    public String story_write(@RequestParam("a_idx") int a_idx,
    						  						@RequestParam("title") String title,
                              @RequestParam("regin") String regin,
                              @RequestParam("enddate") String enddate,
                              @RequestParam("seldate") String seldate,
                              @RequestParam("contents") String contents,
                              @RequestParam("images") MultipartFile[] images) {
        // 이미지 파일 경로 배열 (최대 10개)
        String[] imagePaths = new String[10];
        
        // 저장할 경로 설정
        String uploadDir = "C:/testttttt/www/src/main/resources/static/image/story/";

        // 업로드된 파일들을 서버에 저장하고 파일 경로를 배열에 저장
        for (int i = 0; i < images.length && i < 10; i++) {
            MultipartFile image = images[i];
            if (!image.isEmpty()) {
                String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
                File file = new File(uploadDir, fileName); // 실제 저장 경로
                try {
                    image.transferTo(file);
                    imagePaths[i] = fileName; // 파일명 또는 경로를 저장
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // VO 객체에 값 설정
        TraverserStoryVO story = new TraverserStoryVO();
        story.setTitle(title);
        story.setRegin(regin);
        story.setSeldate(seldate);
        story.setEnddate(enddate);
        story.setContents(contents);
        story.setA_idx(a_idx);
        story.setImge1(imagePaths[0]);
        story.setImge2(imagePaths[1]);
        story.setImge3(imagePaths[2]);
        story.setImge4(imagePaths[3]);
        story.setImge5(imagePaths[4]);
        story.setImge6(imagePaths[5]);
        story.setImge7(imagePaths[6]);
        story.setImge8(imagePaths[7]);
        story.setImge9(imagePaths[8]);
        story.setImge10(imagePaths[9]);
        // 서비스 계층을 통해 DB에 저장
        tss.wirteStory(story);

        return "redirect:/place/traverserStory";
    }
    
    // 게시글 상세보기
    @GetMapping("/place/story/{idx}")
    public ModelAndView viewStory(@PathVariable("idx") int idx) {
        ModelAndView mav = new ModelAndView();
        
        // 조회수 증가
        tss.incrementViewCount(idx);

        // 특정 idx를 가진 게시글을 가져옵니다
        TraverserStoryVO story = tss.getStoryById(idx);
        mav.addObject("story", story);
        mav.setViewName("/place/story_detail");

        return mav;
    }
    
 // 게시글 수정 페이지로 이동
    @GetMapping("/place/story_update/{idx}")
    public ModelAndView editStory(@PathVariable("idx") int idx, HttpSession session) {
        ModelAndView mav = new ModelAndView();

        // 게시글 가져오기
        TraverserStoryVO story = tss.getStoryById(idx);
        AccountsVO user = (AccountsVO) session.getAttribute("user");


        mav.addObject("story", story);
        mav.setViewName("/place/story_update");
        return mav;
    }

    // 게시글 수정 처리
    @PostMapping("/place/story/{idx}")
    public String updateStory(@PathVariable("idx") int idx,
                              @RequestParam("title") String title,
                              @RequestParam("regin") String regin,
                              @RequestParam("enddate") String enddate,
                              @RequestParam("seldate") String seldate,
                              @RequestParam("contents") String contents,
                              @RequestParam("images") MultipartFile[] images) {

        TraverserStoryVO story = tss.getStoryById(idx);

        // 기존 이미지 유지 또는 업데이트
        String[] imagePaths = tss.updateImages(images, story);
        
     // 저장할 경로 설정
        String uploadDir = "C:/sts_test/traverse/www/src/main/resources/static/image/story/";

        // 업로드된 파일들을 서버에 저장하고 파일 경로를 배열에 저장
        for (int i = 0; i < images.length && i < 10; i++) {
            MultipartFile image = images[i];
            if (!image.isEmpty()) {
                String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
                File file = new File(uploadDir, fileName); // 실제 저장 경로
                try {
                    image.transferTo(file);
                    imagePaths[i] = fileName; // 파일명 또는 경로를 저장
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        story.setTitle(title);
        story.setRegin(regin);
        story.setSeldate(seldate);
        story.setEnddate(enddate);
        story.setContents(contents);
        story.setImge1(imagePaths[0]);
        story.setImge2(imagePaths[1]);
        story.setImge3(imagePaths[2]);
        story.setImge4(imagePaths[3]);
        story.setImge5(imagePaths[4]);
        story.setImge6(imagePaths[5]);
        story.setImge7(imagePaths[6]);
        story.setImge8(imagePaths[7]);
        story.setImge9(imagePaths[8]);
        story.setImge10(imagePaths[9]);
        
        tss.updateStory(story);

        return "redirect:/place/story/" + idx;
    }

    // 게시글 삭제 처리
    @GetMapping("/place/story_delete/{idx}")
    public String deleteStory(@PathVariable("idx") int idx, HttpSession session) {
        AccountsVO user = (AccountsVO) session.getAttribute("user");
        TraverserStoryVO story = tss.getStoryById(idx);


        tss.deleteStory(idx);
        return "redirect:/place/traverserStory";
    }
    
    @GetMapping("/place/myplace")
    public ModelAndView viewUserStories(HttpSession session) {
        ModelAndView mav = new ModelAndView();

        AccountsVO user = (AccountsVO) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/member/login");
        }

        List<TraverserStoryVO> userStories = tss.getStoriesByUserId(user.getAccounts_idx());
        mav.addObject("stories", userStories);
        mav.setViewName("/place/myplace");

        return mav;
    }
 
}
