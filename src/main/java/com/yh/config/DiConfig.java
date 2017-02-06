package com.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yh.service.BeanWayService;

//@Configuration是一个组合@Component注解
@Configuration
@ComponentScan("com.yh.service")
public class DiConfig{
	@Bean(initMethod="init",destroyMethod="destroy")
	BeanWayService beanWayService(){
		return new BeanWayService();
	}

}
