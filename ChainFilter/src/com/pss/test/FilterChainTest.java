package com.pss.test;

import com.pss.chain.FilterChain;
import com.pss.domain.Request;
import com.pss.domain.Response;
import com.pss.filter.impl.HtmlFilter;
import com.pss.filter.impl.SensitiveFilter;

public class FilterChainTest {
	
	public static void main(String[] args) {
		
		Response response = new Response();
		response.setRespStr("response--Order:");
		
		Request request = new Request();
		request.setReqStr("This line contians <script>, and name is peng");
		
		FilterChain filterChain = new FilterChain();
		filterChain.addFilters(new HtmlFilter())
					.addFilters(new SensitiveFilter());
		
		filterChain.doFilters(response, request, filterChain);
		
		System.out.println(request.getReqStr());
		System.out.println(response.getRespStr());
	}
}
