package com.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.yh.Interceptor.DemoInterceptor;

/**
 * 普通的Spring配置类
 * @author yh
 *
 */
@Configuration
@EnableWebMvc	//开启一些默认配置,如一些ViewResolver或者MessageConverter等;开启SpringMVC支持,若无此句,重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.yh.controller")
public class SpringMVCConfig extends WebMvcConfigurerAdapter{
	
	//配置JSP的ViewResolver
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	//文件上传
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10 *1024 * 1024);//10M
		return multipartResolver;
	}
	
	//重写方法,对SpringMVC进行配置
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	//重写addInterceptors方法,注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	/**
	 * 其他配置
	 */
	
	//单纯的页面转向;/index直接跳转到/index.jsp
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/sse").setViewName("/sse");
	}
	
	//在Spring MVC 中,路径参数如果带"."的话,"."后面的值将被忽略(/xx.yy)
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer){
		//重写configurePathMatch方法,下面设为false;不忽略"."后面的参数
		configurer.setUseSuffixPatternMatch(false);
	}

}
