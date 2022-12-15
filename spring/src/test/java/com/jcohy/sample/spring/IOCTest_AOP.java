package com.jcohy.sample.spring;

import com.jcohy.sample.spring.aop.MathCalculator;
import com.jcohy.sample.spring.config.MainConfigOfAOP;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

	@Test
	@Disabled
	public void test01() {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigOfAOP.class)) {

			// 1、不要自己创建对象
			// MathCalculator mathCalculator = new MathCalculator();
			// mathCalculator.div(1, 1);
			MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

			mathCalculator.div(1, 0);

			applicationContext.close();
		}
	}

}
