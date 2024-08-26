package com.traverse.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traverse.www.model.LikeDAO;
import com.traverse.www.vo.LikeVO;



@Service
public class LikeService {
   
   @Autowired
   private LikeDAO dao;
   
   
   public List<LikeVO> getboards(String usernick) {
      return dao.selectAll(usernick);
   }


	public String delete(LikeVO idx) {
		return dao.delete(idx);
	}


	public int likeDel(int likeIdx) {
		return dao.likeDel(likeIdx);
	}
  
	public void insertLike(LikeVO likeVO) {
    dao.insert(likeVO);  // DAO를 통해 데이터베이스에 삽입
}
}



