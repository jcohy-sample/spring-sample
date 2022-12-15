package com.jcohy.sample.spring_boot.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 描述: .
 * <p>
 * Copyright © 2022
 * <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:16:08
 * @since 2022.04.0
 */
@Component
public class ConsumerMessage {

	private static final Logger log = LoggerFactory.getLogger(ConsumerMessage.class);

	private final ObjectMapper objectMapper;

	public ConsumerMessage(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	/**
	 * 防止重复消费，可以根据传过来的唯一 ID 先判断缓存数据中是否有数据。
	 *
	 * 有数据则不消费，直接应答处理
	 *
	 * 缓存没有数据，则进行消费处理数据，处理完后手动应答
	 *
	 * 如果消息处理异常，则可以存入数据库中，手动处理
	 * @param channel channel
	 * @param message message
	 * @param json json
	 * @throws IOException /
	 */
	@RabbitListener(queues = RabbitConfig.QUEUE_A)
	public void handlerMessage(@Payload String json, Message message, Channel channel) throws IOException {
		MessageProperties properties = message.getMessageProperties();
		long deliveryTag = properties.getDeliveryTag();
		try {
			Order order = objectMapper.readValue(json, Order.class);
			// 模拟异常
			// int i = 1/0;
			// 手动应答，代表消费者确认收到当前消息，语义上表示消费者成功处理了当前消息。
			log.info("ConsumerA 消费消息成功 deliveryTag： {} | message {}", deliveryTag, json);
			channel.basicAck(deliveryTag, false);

		}
		catch (Exception e) {
			log.info("ConsumerA 消费消息失败 deliveryTag： {} | message {}", deliveryTag, json);
			// 处理消息失败，将消息重新放回队列。
			// 代表消费者拒绝一条或者多条消息，basicNack 是 basicReject 的一个扩展，因为 basicReject 不能拒绝多条消息
			channel.basicNack(deliveryTag, false, true);
		}
	}

	@RabbitListener(queues = RabbitConfig.QUEUE_B)
	public void process(@Payload String json, Message message, Channel channel) throws IOException {
		MessageProperties properties = message.getMessageProperties();
		long deliveryTag = properties.getDeliveryTag();
		try {
			Order order = objectMapper.readValue(json, Order.class);
			// 是否是重复消息
			Boolean redelivered = properties.getRedelivered();
			log.info("ConsumerB 是否是重复消息： {} ", redelivered);

			// 模拟异常
			// int i = 1/0;
			// 手动应答，代表消费者确认收到当前消息，语义上表示消费者成功处理了当前消息。
			log.info("ConsumerB 消费消息成功 deliveryTag： {} | message {}", deliveryTag, json);
			channel.basicAck(deliveryTag, false);

		}
		catch (Exception e) {
			log.info("ConsumerB 消费消息失败 deliveryTag： {} | message {}", deliveryTag, json);
			// 处理消息失败，将消息重新放回队列。
			// 代表消费者拒绝一条或者多条消息，basicNack 是 basicReject 的一个扩展，因为 basicReject 不能拒绝多条消息
			channel.basicNack(deliveryTag, false, true);
		}
	}

}
