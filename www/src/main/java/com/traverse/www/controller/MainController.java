package com.traverse.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.traverse.www.service.MainService;
import com.traverse.www.service.WeatherService;
import com.traverse.www.vo.AccountsVO;
import com.traverse.www.vo.SelPlaceVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private MainService ms;
	
	@Autowired
	private WeatherService ws;

  @GetMapping("/")
  public ModelAndView home(@RequestParam(name = "city", defaultValue = "Seoul") String city) {
    ModelAndView mav = new ModelAndView();
    
    Map<String, Object> weather = ws.getWeather(city);
		
		mav.addObject("weather", weather);
		mav.addObject("city", city);

    mav.setViewName("home");
    
    mav.addObject("test", ms.test());

    return mav;
  }
  
  @GetMapping("/gyeonggi")
  public ModelAndView gyeonggi(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 31;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/gyeonggi")
  public ModelAndView gyeonggi(@RequestParam(name = "gyeonggi", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
    if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/gangwon")
  public ModelAndView gangwon(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 32;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/gangwon")
  public ModelAndView gangwon(@RequestParam(name = "gangwon", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/chungbuk")
  public ModelAndView chungbuk(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 33;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/chungbuk")
  public ModelAndView chungbuk(@RequestParam(name = "chungbuk", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/chungnam")
  public ModelAndView chungnam(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 34;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/chungnam")
  public ModelAndView chungnam(@RequestParam(name = "chungnam", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/gyeongbuk")
  public ModelAndView gyeongbuk(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 35;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/gyeongbuk")
  public ModelAndView gyeongbuk(@RequestParam(name = "gyeongbuk", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/gyeongnam")
  public ModelAndView gyeongnam(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 36;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/gyeongnam")
  public ModelAndView gyeongnam(@RequestParam(name = "gyeongnam", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/jeonbuk")
  public ModelAndView jeonbuk(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 37;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/jeonbuk")
  public ModelAndView jeonbuk(@RequestParam(name = "jeonbuk", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/jeonnam")
  public ModelAndView jeonnam(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	int areaCode = 38;
  	
  	ms.delete(a_idx);
  	ms.sel_areaCode(areaCode, a_idx);
  	
  	return mav;
  }
  
  @PostMapping("/jeonnam")
  public ModelAndView jeonnam(@RequestParam(name = "jeonnam", required = false) List<Integer> selectePlaces, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("redirect:/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	int sigunguCode1 = 0, sigunguCode2 = 0, sigunguCode3 = 0;
    
  	if (selectePlaces != null && !selectePlaces.isEmpty()) {
    	for (int i = 0; i < selectePlaces.size(); i++) {
    		int place = selectePlaces.get(i);

        switch (i) {
        case 0: sigunguCode1 = place; break;
        case 1: sigunguCode2 = place; break;
        case 2: sigunguCode3 = place; break;
        }
      }
      ms.sel_sigunguCode(a_idx, sigunguCode1, sigunguCode2, sigunguCode3);
    }
  	mav.setViewName("redirect:/duration");
  	
  	return mav;
  }
  
  @GetMapping("/duration")
  public ModelAndView sel_area(@RequestParam(name = "areaCode", required = false) Integer areaCode, HttpSession session) {
    ModelAndView mav = new ModelAndView();
    
    AccountsVO user = (AccountsVO) session.getAttribute("user");
    
    if (user == null) {
        mav.setViewName("redirect:/member/login");
        return mav;
    }

    if (areaCode != null) {
        int a_idx = user.getAccounts_idx();
        ms.delete(a_idx);
        ms.sel_areaCode(areaCode, a_idx);
    }
    
    return mav;
  }

  @PostMapping("/duration")
  public ModelAndView duration(@RequestParam(name = "duration") int duration, HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	ms.sel_duration(duration, a_idx);
  	
  	mav.setViewName("redirect:/recommendResult");
  	
  	return mav;
  }
  
  @GetMapping("/recommendResult")
  public ModelAndView recommendResult(HttpSession session) {
  	ModelAndView mav = new ModelAndView();
  	
  	AccountsVO user = (AccountsVO) session.getAttribute("user");
  	
  	if (user == null) {
  		mav.setViewName("/member/login");
  		return mav;
  	}
  	
  	int a_idx = user.getAccounts_idx();
  	
  	SelPlaceVO result = ms.getSelPlace(a_idx);
  	
  	mav.addObject("result", result);
  	mav.addObject("place", ms.getPlaces(result));
  	
  	return mav;
  }
  
}
