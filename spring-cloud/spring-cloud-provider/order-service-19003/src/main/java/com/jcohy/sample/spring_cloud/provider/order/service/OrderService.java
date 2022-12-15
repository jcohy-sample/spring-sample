package com.jcohy.sample.spring_cloud.provider.order.service;

import com.jcohy.sample.spring_cloud.provider.order.entity.Order;
import com.jcohy.sample.spring_cloud.provider.order.feign.AccountFeignClient;
import com.jcohy.sample.spring_cloud.provider.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author fangliangsheng
 */
@Service
public class OrderService {

	@Autowired
	private AccountFeignClient accountFeignClient;

	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public void create(String userId, String commodityCode, Integer count) {

		BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

		Order order = new Order();
		order.setUserId(userId);
		order.setCommodityCode(commodityCode);
		order.setCount(count);
		order.setMoney(orderMoney);

		orderRepository.save(order);

		accountFeignClient.debit(userId, orderMoney);

	}

}
