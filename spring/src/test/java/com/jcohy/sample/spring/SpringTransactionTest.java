package com.jcohy.sample.spring;

import com.jcohy.sample.spring.tx.TransactionConfig;
import com.jcohy.sample.spring.tx.TransactionUserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTransactionTest {

	@Test
	@Disabled
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);

		TransactionUserService transactionUserService = applicationContext.getBean(TransactionUserService.class);

		transactionUserService.insertUser();
		applicationContext.close();
	}

}
