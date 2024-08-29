package com.traverse.www.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.traverse.www.model.TraverserStoryDAO;
import com.traverse.www.vo.TraverserStoryVO;

@Service
public class TraverserStoryService {
	
	@Autowired
	private TraverserStoryDAO dao;

	public int wirteStory(TraverserStoryVO input) {
		
		return dao.insert(input);
	}

  // 모든 게시글을 가져오는 메서드 추가
  public List<TraverserStoryVO> getAllStories() {
      return dao.selectAllStories();
  }
  
  public TraverserStoryVO getStoryById(int idx) {
  	dao.incrementViewCount(idx);
    return dao.selectStoryById(idx);
}
  
  // 게시글 업데이트 메서드
  public void updateStory(TraverserStoryVO story) {
      dao.update(story);
  }

  // 게시글 삭제 메서드
  public void deleteStory(int idx) {
      dao.delete(idx);
  }

  // 이미지 업데이트 메서드
  public String[] updateImages(MultipartFile[] images, TraverserStoryVO story) {
      String[] imagePaths = new String[10];
      String uploadDir = "C:/spring/traverse/www/src/main/resources/static/story/";

      for (int i = 0; i < images.length && i < 10; i++) {
          MultipartFile image = images[i];
          if (!image.isEmpty()) {
              String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
              File file = new File(uploadDir, fileName);
              try {
                  image.transferTo(file);
                  imagePaths[i] = fileName;
              } catch (IOException e) {
                  e.printStackTrace();
              }
          } else {
              // 기존 이미지를 유지
              imagePaths[i] = story.getImge1(); // 예시로 첫 번째 이미지를 가져옴
          }
      }
      return imagePaths;
  }

public List<TraverserStoryVO>resultSearch(String search) {
	
	return dao.selectSearch(search);
}

}
