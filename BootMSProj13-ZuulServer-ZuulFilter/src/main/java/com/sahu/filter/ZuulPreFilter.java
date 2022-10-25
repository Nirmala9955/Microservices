package com.sahu.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPreFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPreFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true; //enable this filter
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object (it contain access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		//Get HttpServletRequest object from RequestContext
		HttpServletRequest request = context.getRequest();
		System.out.println("ZuulPreFilter.run() : from Pre filter");
		//Write log messages about current request
		logger.info("From Pre Filter");
		logger.info("Request content type: "+request.getContentType());
		logger.info("Request mode: "+request.getMethod());
		logger.info("Request path: "+request.getServletPath());
		logger.info("Request URI: "+request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE; //Makes  filter as Pre filter
	}

	@Override
	public int filterOrder() {
		return 0; //High priority
	}

}
