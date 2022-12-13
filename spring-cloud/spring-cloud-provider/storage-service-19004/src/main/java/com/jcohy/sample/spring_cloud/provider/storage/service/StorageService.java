package com.jcohy.sample.spring_cloud.provider.storage.service;

import com.jcohy.sample.spring_cloud.provider.storage.entity.Storage;
import com.jcohy.sample.spring_cloud.provider.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;

	@Transactional
	public void deduct(String commodityCode, int count) {
		Storage storage = storageRepository.findByCommodityCode(commodityCode);
		storage.setCount(storage.getCount() - count);

		storageRepository.save(storage);
	}

}
