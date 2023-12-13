package com.jcohy.sample.spring;

import com.jcohy.sample.spring.event.EventConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);

		// 发布事件；
		applicationContext.publishEvent(new ApplicationEvent("我发布的时间") {
		});

		applicationContext.close();
	}

}
