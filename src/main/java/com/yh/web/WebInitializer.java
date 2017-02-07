package com.yh.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.yh.config.SpringMVCConfig;

/**
 * WebApplicationInitializer 是 Spring 提供用来配置 Servlet 3.0+配置的接口，
 * 从而实现了替代web.xml的位置。实现此接口将会自动被SpringServletContainerInitializer(用来启动Servlet3.0容器)获取到
 * @author yh
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//新建WebApplicationContext,注册配置类,并将其和当前servletContext关联。
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringMVCConfig.class);
		ctx.setServletContext(servletContext);
		
		//注册Spring MVC 的DispatcherServlet
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}

}
