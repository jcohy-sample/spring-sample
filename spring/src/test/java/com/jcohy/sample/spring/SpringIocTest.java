package com.jcohy.sample.spring;

import com.jcohy.sample.spring.ioc.Blue;
import com.jcohy.sample.spring.ioc.Color;
import com.jcohy.sample.spring.ioc.ColorFactoryBean;
import com.jcohy.sample.spring.ioc.Person;
import com.jcohy.sample.spring.scan.ScanConfig;
import com.jcohy.sample.spring.ioc.IocConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpringIocTest {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig.class);

	@Test
	public void testImport() {

		List<String> definitionNames = Arrays.asList(applicationContext.getBeanDefinitionNames());

		Assertions.assertThat(definitionNames).contains("com.jcohy.sample.spring.ioc.Blue",
				"com.jcohy.sample.spring.ioc.Yellow",
				"com.jcohy.sample.spring.ioc.Color",
				"com.jcohy.sample.spring.ioc.Red",
				"person",
				"bill",
				"colorFactoryBean",
				"rainBow");
		Assertions.assertThat(definitionNames).doesNotContain("linus");

		Blue bean = applicationContext.getBean(Blue.class);
		Assertions.assertThat(bean).isNotNull();

		// 工厂 Bean 获取的是调用 getObject 创建的对象
		// 工厂 Bean 获取的是调用 getObject 创建的对象,要获取工厂 Bean 本身,我们需要给id前面加一个 &colorFactoryBean
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		Object bean3 = applicationContext.getBean("colorFactoryBean");
		// 调用 FactoryBean 的 getObject 方法
		System.out.println(bean2.getClass());
		System.out.println(Color.class);
		Assertions.assertThat(bean2.getClass()).isEqualTo(Color.class);
		Assertions.assertThat(bean2).isEqualTo(bean3);

		Object bean4 = applicationContext.getBean("&colorFactoryBean");
		Assertions.assertThat(bean4.getClass()).isEqualTo(ColorFactoryBean.class);
	}

	@Test
	public void testCondition() {
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		// 动态获取环境变量的值；Windows 10
		String property = environment.getProperty("os.name");

		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		if (property.contains("Windows")) {
			Assertions.assertThat(persons).hasSize(2);
		} else {
			Assertions.assertThat(persons).hasSize(1);
		}
	}

	@Test
	public void test02() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				IocConfig.class);
		// String[] definitionNames = applicationContext.getBeanDefinitionNames();
		// for (String name : definitionNames) {
		// System.out.println(name);
		// }
		//
		System.out.println("ioc容器创建完成....");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}

	@SuppressWarnings("resource")
	@Test
	@Disabled
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ScanConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
