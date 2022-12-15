package com.jcohy.sample.spring_boot.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * 描述: .
 * <p>
 * Copyright © 2022
 * <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:16:24
 * @since 2022.04.0
 */
@Controller
public class IndexController implements RabbitCallback {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	private final ProducerMessage producerMessage;

	private String message;

	public IndexController(ProducerMessage producerMessage) {
		this.producerMessage = producerMessage;
	}

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "index";
	}

	@GetMapping("/a")
	@ResponseBody
	public Callable<String> a() {
		return () -> {
			ObjectMapper objectMapper = new ObjectMapper();

			Order order = new Order(UUID.randomUUID().toString(), "TEST", "订单已生产");
			message = null;
			log.info("开始发送消息");
			producerMessage.sendMessageToA(objectMapper.writeValueAsString(order), this);
			log.info("发送消息之前 message: {}", message);
			for (;;) {
				if (message != null) {
					log.info("发送消息之后 message: {}", message);
					break;
				}
			}
			return message;
		};
	}

	@Override
	public void returnCallBack(String message) {
		this.message = message;
	}

}
