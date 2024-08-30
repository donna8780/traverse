package com.traverse.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
        String uploadDir = "C:/spring/traverse/www/src/main/resources/static/story/";

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

        // 특정 idx를 가진 게시글을 가져옵니다
        TraverserStoryVO story = tss.getStoryById(idx);
        mav.addObject("story", story);
        mav.setViewName("/place/story_detail");

        return mav;
    }
}
