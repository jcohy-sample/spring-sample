package com.jcohy.sample.spring_cloud.provider.business.service;

import com.jcohy.sample.spring_cloud.provider.business.feign.OrderFeignClient;
import com.jcohy.sample.spring_cloud.provider.business.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author fangliangsheng
 */
@Service
public class BusinessService {

	@Autowired
	private StorageFeignClient storageFeignClient;

	@Autowired
	private OrderFeignClient orderFeignClient;

	/**
	 * 减库存，下订单
	 * @param userId
	 * @param commodityCode
	 * @param orderCount
	 */
	@GlobalTransactional
	public void purchase(String userId, String commodityCode, int orderCount) {
		storageFeignClient.deduct(commodityCode, orderCount);

		orderFeignClient.create(userId, commodityCode, orderCount);
	}

}
