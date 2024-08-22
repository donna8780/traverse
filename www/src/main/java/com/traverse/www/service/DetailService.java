package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.traverse.www.model.DetailDAO;
import com.traverse.www.vo.DetailVO;

@Service
public class DetailService {
    
    @Autowired
    private DetailDAO dao;

    // 특정 idx로 상세 정보 가져오기
    public DetailVO getDetailById(int idx) {
        return dao.findById(idx);
    }
}
