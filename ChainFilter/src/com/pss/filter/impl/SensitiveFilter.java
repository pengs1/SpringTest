package com.pss.filter.impl;

import com.pss.chain.FilterChain;
import com.pss.domain.Request;
import com.pss.domain.Response;
import com.pss.filter.Filter;

public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(Response response, Request request, FilterChain filterChain) {
		request.reqStr = request.reqStr.replace("peng", "WAW2-->SensitiveFilter");
		filterChain.doFilters(response, request, filterChain);
		response.respStr += "-->SensitiveFilter";
	}

}
