package com.jcohy.sample.spring;

import com.jcohy.sample.spring.tx.TxConfig;
import com.jcohy.sample.spring.tx.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

		UserService userService = applicationContext.getBean(UserService.class);

		userService.insertUser();
		applicationContext.close();
	}

}
