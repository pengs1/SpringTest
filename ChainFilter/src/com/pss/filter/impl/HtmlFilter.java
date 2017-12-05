package com.pss.filter.impl;

import com.pss.chain.FilterChain;
import com.pss.domain.Request;
import com.pss.domain.Response;
import com.pss.filter.Filter;

public class HtmlFilter implements Filter {

	@Override
	public void doFilter(Response response, Request request, FilterChain filterChain) {
		request.reqStr = request.reqStr.replace("<script>", "QAQ1-->HtmlFilter");
		filterChain.doFilters(response, request, filterChain);
		response.respStr += "-->HtmlFilter";
	}

}
