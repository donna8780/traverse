package com.traverse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traverse.www.service.KakaoApiService;

@RestController
public class TransitRouteController {

    @Autowired
    private KakaoApiService kakaoApiService;

    @GetMapping("/transit-route")
    public String getTransitRoute(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination) {

        return kakaoApiService.getTransitRoute(origin, destination);
    }
}
