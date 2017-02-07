package com.yh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.yh.service")
@EnableScheduling	//开启对计划任务的支持
public class TaskSchedulerConfig {

}
