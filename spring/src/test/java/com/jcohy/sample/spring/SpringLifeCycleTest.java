package com.jcohy.sample.spring;

import com.jcohy.sample.spring.lifecycle.LifeCycleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLifeCycleTest {

	@Test
	public void test01() {
		// 1、创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				LifeCycleConfig.class);
		applicationContext.close();
	}

}
