package com.pss.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;

public class RestTemplateTest {
	
	// weather https service url
	private static final String WEATHER_URL = "http://www.sojson.com/open/api/weather/json.shtml?city={city}";
	
	private static final String MEDIA_TYPE = "application/json; charset=UTF-8";
	
	private static final String HEADER_NAME = "Accept";
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("city", "上海");
		String weatherResult = restTemplate.getForObject(WEATHER_URL, String.class, params);
		JSONObject jsonResult = JSONObject.fromObject(weatherResult);
		System.out.println(weatherResult);
	}
	
}
