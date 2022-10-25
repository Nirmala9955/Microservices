package com.sahu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// false: disable filter
		// true: disable filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Filter code/ logic: (Logging logics using SLF4J)
		return null;
	}

	@Override
	public String filterType() {
		// "pre" or "post" or "route" or "error"
		return "pre"; //pre filter
	}

	@Override
	public int filterOrder() {
		// Low value indicate high priority and high value indicate low priority 
		return 0;
	}

}
