package com.jemmyee.core.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 后台登陆认证拦截器
 * @author:jemmyee@gmail.com
 * @version:v1.0
 */
public class LogonAuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	private static Log log= LogFactory.getLog(LogonAuthenticationInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			if(request.getSession().getAttribute(Constants.ONLINE_ADMIN_USER_ID)==null)
			{
				log.debug("[break into]uri:"+request.getRequestURI().toString());
				request.getRequestDispatcher("/login/index").forward(request, response);
				return false;
			}
		return true;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}
