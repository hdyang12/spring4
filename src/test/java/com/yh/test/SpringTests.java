package com.yh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yh.config.TaskSchedulerConfig;
import com.yh.service.ScheduledTaskService;

/**
 * Spring测试类
 * @author yh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	//在JUnit环境下提供Spring TestContext Framework的功能
//用来加载配置application,其中classes 属性用来加载配置类
@ContextConfiguration(classes = {TaskSchedulerConfig.class})
public class SpringTests {
	@Autowired
	private ScheduledTaskService scheduledTaskService;
	
	@Test
	public void ScheduledTaskTest(){
		
	}

}
