package com.jcohy.sample.spring;

import com.jcohy.sample.spring.autowired.AutowiredConfig;
import com.jcohy.sample.spring.autowired.service.BookService;
import com.jcohy.sample.spring.autowired.bean.Boss;
import com.jcohy.sample.spring.lifecycle.Car;
import com.jcohy.sample.spring.ioc.Color;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAutowiredTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AutowiredConfig.class);

		BookService bookService = applicationContext.getBean(BookService.class);
		Assertions.assertThat(bookService).isNotNull();

		Boss boss = applicationContext.getBean(Boss.class);
		Assertions.assertThat(boss).isNotNull();

		applicationContext.close();
	}

}
