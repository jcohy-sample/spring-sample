package com.jcohy.sample.spring_cloud.provider.order.controller;

import com.jcohy.sample.spring_cloud.provider.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author fangliangsheng
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/create")
	public Boolean create(String userId, String commodityCode, Integer count) {

		orderService.create(userId, commodityCode, count);
		return true;
	}

}
