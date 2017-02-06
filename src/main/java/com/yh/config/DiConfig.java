package com.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yh.service.BeanWayService;

//@Configuration��һ�����@Componentע��
@Configuration
@ComponentScan("com.yh.service")
public class DiConfig{
	@Bean(initMethod="init",destroyMethod="destroy")
	BeanWayService beanWayService(){
		return new BeanWayService();
	}

}
