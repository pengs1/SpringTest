package com.pss.chain;

import java.util.ArrayList;
import java.util.List;

import com.pss.domain.Request;
import com.pss.domain.Response;
import com.pss.filter.Filter;

public class FilterChain {
	
	List<Filter> filters = new ArrayList<Filter>();
	
	private int index = 0;
	
	public FilterChain addFilters(Filter filter) {
		filters.add(filter);
		return this;
	}
	
	public void doFilters(Response response, Request request, FilterChain filterChain) {
		// if the size is big than the filers, return
		if(index >= filters.size()) return;
		
		Filter filter = filters.get(index);
		index ++;
		filter.doFilter(response, request, filterChain);
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
}
