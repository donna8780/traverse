package com.traverse.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traverse.www.service.ApiService;
import com.traverse.www.vo.ApiVO;


@RestController
public class ApiController {
	
	@Autowired
	private ApiService as;
	
	@GetMapping("member/fetch")
	public String fetch() {
		try {
			List<ApiVO> dataList = as.fetchDataFromApi();
			as.saveDataToDatabase(dataList);
			return "성공";
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "실패";
		}
		
	}
	
	
}
