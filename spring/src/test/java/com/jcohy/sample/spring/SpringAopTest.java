package com.jcohy.sample.spring;

import com.jcohy.sample.spring.aop.MathCalculator;
import com.jcohy.sample.spring.aop.AopConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopTest {

	@Test
	public void test01() {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class)) {
			// 1、不要自己创建对象
			// MathCalculator mathCalculator = new MathCalculator();
			// mathCalculator.div(1, 1);
			MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
			Assertions.assertThrows(ArithmeticException.class,() -> mathCalculator.div(1, 0));
			applicationContext.close();
		}
	}

}
