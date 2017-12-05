package com.pss.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.enums.EnumUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;

/**
 * Test for RestTemplate
 * 
 * @author songsong.peng
 *
 */
@Component
public class RestTemplateUtils {
	
	// weather https service url
	private static final String WEATHER_URL = "http://www.sojson.com/open/api/weather/json.shtml?city={CITY}";
	
	private static final String CHARSET_NAME_UTF8 = "UTF-8";
	
	//private static final String MEDIA_TYPE = "application/json; charset=UTF-8";
	
	//private static final String HEADER_NAME = "Accept";
	
	/**
	 * This method is used to get current weather information.
	 *  
	 * @param cityName the name of city
	 * @return the weather information 
	 * @throws UnsupportedEncodingException 
	 */
	public JSONObject getWeather(String cityName) {
		// Create an restTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Set paramter
		Map<String,String> params = new HashMap<String,String>();
		params.put("CITY", cityName);
		
		// replace the paramter
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(WEATHER_URL, String.class, params);
		return JSONObject.fromObject(responseEntity);
	}
}
