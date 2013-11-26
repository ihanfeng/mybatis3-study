package com.hanfeng.ssm3.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.hanfeng.ssm3.model.User;
import com.hanfeng.ssm3.service.IUserService;

/**
 * @author hanfeng E-mail:zhdevelop@gmail.com
 * @version 2013年11月26日 下午1:18:50
 * 
 */

public class TestSSM {
	ApplicationContext ctx;

	@Before
	public void bofore() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "spring.xml",
				"spring-mybatis.xml", "spring-mvc.xml" });
		System.out.println("获取Spring上下文：" + ctx);
	}

	@Test
	public void test() {
		IUserService userService = (IUserService) ctx.getBean("userService");
		User user = userService.getUserById(1);
		System.out.println(JSON.toJSONString(user));
	}
}
