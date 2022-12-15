package com.jcohy.sample.spring.ext;

import com.jcohy.sample.spring.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理： BeanPostProcessor：bean 后置处理器，bean 创建对象初始化前后进行拦截工作的
 *
 */
@ComponentScan("com.jcohy.sample.spring.ext")
@Configuration
public class ExtConfig {

	@Bean
	public Blue blue() {
		return new Blue();
	}

}
