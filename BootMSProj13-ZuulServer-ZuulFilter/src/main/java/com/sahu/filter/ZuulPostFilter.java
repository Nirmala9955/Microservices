package com.sahu.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPostFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true; //enable this filter
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object (it contain access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		//Get HttpServletRequest object from RequestContext
		HttpServletResponse reponse = context.getResponse();
		System.out.println("ZuulPostFilter.run() : from Post filter");
		//Write log messages about current request
		logger.info("From Post Filter");
		logger.info("Response content type: "+reponse.getContentType());
		logger.info("Response status: "+reponse.getStatus());
		logger.info("Response status code: "+reponse.getHeader("host"));
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE; //Makes  filter as Pre filter
	}

	@Override
	public int filterOrder() {
		return 0; //High priority
	}

}
