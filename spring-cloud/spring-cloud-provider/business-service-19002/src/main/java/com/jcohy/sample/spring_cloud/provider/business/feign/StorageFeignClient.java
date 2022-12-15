package com.jcohy.sample.spring_cloud.provider.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author fangliangsheng
 */
@FeignClient(name = "storage-service", url = "127.0.0.1:19004")
public interface StorageFeignClient {

	@GetMapping("/deduct")
	void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
