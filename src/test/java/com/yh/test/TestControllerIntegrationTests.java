package com.yh.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yh.config.SpringMVCConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMVCConfig.class})
@WebAppConfiguration("src/main/resources")//指定web资源位置
public class TestControllerIntegrationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	MockHttpSession session;//注入模拟的http session 
	
	@Autowired
	MockHttpServletRequest request;//注入模拟的http request 
	
	@Before
	public void setup(){
		//模拟MVC对象,初始化
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testHelloController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/index"))//模拟向/index进行get请求
			.andExpect(MockMvcResultMatchers.status().isOk())//预期返回状态为200
			.andExpect(MockMvcResultMatchers.view().name("index"))//预期view的名称为page
			.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/index.jsp"));
//			.andExpect(MockMvcResultMatchers.model().attribute("msg", "msgValue"));
		
	}

}
