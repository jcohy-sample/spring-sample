package com.jcohy.sample.spring_boot.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:15:36
 * @since 2022.04.0
 */
@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_A = "my_mq_exchange_A";
    public static final String EXCHANGE_B = "my_mq_exchange_B";

    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";

    public static final String ROUTE_KEY_A = "spring-boot-routeingKey_A";
    public static final String ROUTE_KEY_B = "spring-boot-routeingKey_B";

    @Bean
    public MappingJackson2HttpMessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    /**
     * 消费者配置
     * <ol>
     *     <li>设置交换类型</li>
     *     <li>将队列绑定到交换机
     *      <ul>
     *          <li>FanoutExchange: 将消息分发到所有的绑定队列，无 route key 的概念</li>
     *          <li>HeadersExchange: 通过添加属性 key-value 匹配 DirectExchange，按照 route key 进行分发</li>
     *          <li>TopicExchange: 多关键字匹配</li>
     *       </ul>
     *     </li>
     * </ol>
     */
    @Bean
    public DirectExchange defaultExchangeA() {
        return new DirectExchange(EXCHANGE_A,true,false);
    }

    @Bean
    public DirectExchange defaultExchangeB() {
        return new DirectExchange(EXCHANGE_B,true,false);
    }

    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A,true);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B,true);
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(defaultExchangeA()).with(ROUTE_KEY_A);
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(defaultExchangeB()).with(ROUTE_KEY_B);
    }
}
