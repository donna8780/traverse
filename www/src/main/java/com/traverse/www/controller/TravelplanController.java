package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.TravelplanService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.SelPlaceVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class TravelplanController {
	
	@Autowired
	private TravelplanService ts;
	
	@GetMapping("place/travelplan")
	public void travelplan() {}
	
	@GetMapping("place/planadd")
	public ModelAndView planadd(@RequestParam("p_idx") int p_idx,
	                            @RequestParam("a_idx") int a_idx,
	                            @RequestParam("areaCode") int areaCode,
	                            @RequestParam("sigunguCode1") int sigunguCode1,
	                            @RequestParam("sigunguCode2") int sigunguCode2,
	                            @RequestParam("sigunguCode3") int sigunguCode3,
	                            @RequestParam("sel_idx") int sel_idx,
	                            @RequestParam("duration") int duration) {

	    ModelAndView mav = new ModelAndView();

	    SelPlaceVO result = new SelPlaceVO();
	    result.setA_idx(a_idx);
	    result.setAreaCode(areaCode);
	    result.setSigunguCode1(sigunguCode1);
	    result.setSigunguCode2(sigunguCode2);
	    result.setSigunguCode3(sigunguCode3);
	    result.setSel_idx(sel_idx);
	    result.setDuration(duration/5);
	    
	    
	   
	    ts.planadd(p_idx,a_idx,areaCode,sigunguCode1,sigunguCode2,sigunguCode3,duration);
	    
	    
	    mav.setViewName("redirect:/recommendResult");
	    return mav;
	    
	}

}
