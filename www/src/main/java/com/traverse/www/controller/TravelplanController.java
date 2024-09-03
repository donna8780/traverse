package com.traverse.www.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.TravelplanService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.PlaceVO;
import com.traverse.www.vo.SelPlaceVO;
import com.traverse.www.vo.TravelplanVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("place/")
public class TravelplanController {
	
	@Autowired
	private TravelplanService ts;
	
	@GetMapping("travelplan")
	public ModelAndView travelplan(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		
		if(user == null) {
			mav.setViewName("redirect:/member/login");
		}else {

			mav.addObject("user",session.getAttribute("user"));
			mav.addObject("place", ts.getPlace(user.getAccounts_idx()));

			
			mav.setViewName("place/travelplan");
		}
		
		return mav;
	}
	
	@GetMapping("planadd")
	public ModelAndView planadd(@RequestParam("p_idx") int p_idx,
	                            @RequestParam("a_idx") int a_idx,
	                            @RequestParam("areaCode") int areaCode,
	                            @RequestParam("sigunguCode1") int sigunguCode1,
	                            @RequestParam("sel_idx") int sel_idx,
	                            @RequestParam("duration") int duration,
	                            @RequestParam("seldate")String seldate,
	                            @RequestParam("day") int day) {

	    ModelAndView mav = new ModelAndView();
	    int duration1 = duration /5;
	    
	    TravelplanVO result = new TravelplanVO();
	    result.setA_idx(a_idx);
	    result.setAreaCode(areaCode);
	    result.setSigunguCode1(sigunguCode1);
	    result.setDuration(duration1);
	    result.setDay(day);
	    
	    ts.planadd(p_idx,a_idx,areaCode,sigunguCode1,duration1,seldate,day);
	    
	    mav.setViewName("redirect:/recommendResult?seldate="+seldate);
	    return mav;
	}
	@GetMapping("travelplandetail")
	public ModelAndView travelplandetail(@RequestParam("seldate")String seldate, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		int user_idx = user.getAccounts_idx();
		
		mav.addObject("Planplace", ts.getPlanplace(user_idx,seldate));
		
		return mav;
	}
	
	@GetMapping("dayplan")
	@ResponseBody
	public List<PlaceVO> dayplan(@RequestParam("day")int day, @RequestParam("seldate")String seldate,HttpSession session) {
		
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		int user_idx = user.getAccounts_idx();
		
		List<PlaceVO> dayplan = ts.getdayplan(user_idx,day,seldate);
		
		return dayplan;
	}
	
	@GetMapping("travelplandel")
	public String travelplandel(@RequestParam("seldate")String seldate,HttpSession session) {
		AccountsVO user = (AccountsVO) session.getAttribute("user");
		int user_idx = user.getAccounts_idx();
		ts.travelplandel(user_idx,seldate);
		
		return "redirect:/place/travelplan";
	}
	

}
