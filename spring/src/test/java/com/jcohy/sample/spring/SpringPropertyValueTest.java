package com.jcohy.sample.spring;

import com.jcohy.sample.spring.property.Person;
import com.jcohy.sample.spring.property.PropertyValuesConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringPropertyValueTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			PropertyValuesConfig.class);

	@Test
	public void test01() {
		Person person = (Person) applicationContext.getBean("person");
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		Assertions.assertThat(property).isEqualTo("小李四");
		applicationContext.close();
	}
}
