package com.sahu.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulErrorFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulErrorFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true; //enable this filter
	}

	@Override
	public Object run() throws ZuulException {
		//Get RequestContext object (it contain access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		//Get Throwable object
		Throwable throwable = context.getThrowable();
		System.out.println("ZuulErrorFilter.run() : from Error filter");
		//Write log messages about current request
		logger.info("From Error Filter");
		logger.info("Exception message: "+throwable.getMessage()+" class name: "+throwable);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE; //Makes  filter as Pre filter
	}

	@Override
	public int filterOrder() {
		return 0; //High priority
	}

}
