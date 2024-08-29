package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return dao.selectStoryById(idx);
}

}
