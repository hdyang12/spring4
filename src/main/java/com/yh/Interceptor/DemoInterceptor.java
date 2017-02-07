package com.yh.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器(Interceptor)实现对每一个请求处理前后进行相关的业务处理,类似于Servlet的Filter
 * 可让普通的Bean实现HanlderInterceptor接口或继承HandlerInterceptorAdapter类来实现自定义拦截器
 * @author yh
 *
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
	
	//重写preHandle,在请求发生前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		Long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	//重写postHandle,在请求发生后执行
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		Long endTime = System.currentTimeMillis();
		System.out.println("本次请求的处理时间为：" + new Long(endTime - startTime) + "ms");
		request.setAttribute("handlingTime", endTime - startTime);
	}
}
