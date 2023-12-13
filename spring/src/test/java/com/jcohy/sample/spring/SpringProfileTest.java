package com.jcohy.sample.spring;

import com.jcohy.sample.spring.ioc.Yellow;
import com.jcohy.sample.spring.profile.ProfileConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class SpringProfileTest {

	// 1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
	// 2、代码的方式激活某种环境；
	@Test
	public void testWithDev() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 1、创建一个applicationContext
		// 2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		// 3、注册主配置类
		applicationContext.register(ProfileConfig.class);
		// 4、启动刷新容器
		applicationContext.refresh();

		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		Assertions.assertThat(namesForType).hasSize(1).contains("devDataSource");

		applicationContext.close();
	}

	@Test
	public void testWithTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 1、创建一个applicationContext
		// 2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		// 3、注册主配置类
		applicationContext.register(ProfileConfig.class);
		// 4、启动刷新容器
		applicationContext.refresh();

		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		Assertions.assertThat(namesForType).hasSize(1).contains("testDataSource");

		applicationContext.close();
	}

	@Test
	public void testWithProd() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 1、创建一个applicationContext
		// 2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("prod");
		// 3、注册主配置类
		applicationContext.register(ProfileConfig.class);
		// 4、启动刷新容器
		applicationContext.refresh();

		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		Assertions.assertThat(namesForType).hasSize(1).contains("prodDataSource");

		applicationContext.close();
	}

}
