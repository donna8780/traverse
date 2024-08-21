package com.traverse.www.service;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	private final RestTemplate rt;
	
	// 생성자에서 rt 초기화시킴
	public WeatherService() {
		rt = new RestTemplate();
	}

	public Map<String, Object> getWeather(String city) {
		String apiKey = "3f8f9e261af9ec5e9fb7b4634a4ec8d8";
		String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, apiKey);
		
		return rt.exchange(
        url,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();
	}
}