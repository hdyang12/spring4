package com.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.yh.conditional.LinuxCondition;
import com.yh.conditional.WindowsCondition;
import com.yh.service.LinuxListService;
import com.yh.service.ListService;
import com.yh.service.WindowsListService;

/**
 * 条件注解 @Conditional
 * 在 Spring Boot中将会大量用到条件注解
 * @author yh
 *
 */
@Configuration
public class ConditionConfig {
	
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowsListService(){
		return new WindowsListService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService(){
		return new LinuxListService();
	}

}
