package com.yh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yh.config.TaskSchedulerConfig;
import com.yh.service.ScheduledTaskService;

/**
 * Spring������
 * @author yh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)	//��JUnit�������ṩSpring TestContext Framework�Ĺ���
//������������application,����classes ������������������
@ContextConfiguration(classes = {TaskSchedulerConfig.class})
public class SpringTests {
	@Autowired
	private ScheduledTaskService scheduledTaskService;
	
	@Test
	public void ScheduledTaskTest(){
		
	}

}
