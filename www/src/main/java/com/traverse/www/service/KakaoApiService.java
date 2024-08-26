package com.traverse.www.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoApiService {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public String getTransitRoute(String origin, String destination) {
        String apiUrl = "https://apis-navi.kakaomobility.com/v1/route/transit";
        String queryParams = "?origin=" + origin + "&destination=" + destination + "&waypoints=";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoApiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl + queryParams, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
