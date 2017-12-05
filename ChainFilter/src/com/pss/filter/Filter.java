package com.pss.filter;

import com.pss.chain.FilterChain;
import com.pss.domain.Request;
import com.pss.domain.Response;

public interface Filter {

	void doFilter(Response response, Request request, FilterChain filterChain);

}
