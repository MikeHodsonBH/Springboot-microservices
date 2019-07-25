package com.june.apps.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestHeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(StringUtils.isBlank(request.getHeader("user-auth-key")) || StringUtils.isBlank(request.getHeader("App-Name")) || !(request.getHeader("App-Name").equals("Cool App") ? true : (request.getHeader("App-Name").equals("Grand Aries") ? true : request.getHeader("App-Name").equals("Ancient Stitch") ? true : false))) {
			throw new InvalidHeadersException("Invalid Request");
		}
		
		return super.preHandle(request, response, handler);
	}

}
