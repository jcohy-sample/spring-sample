package com.jcohy.sample.spring_cloud.provider.storage.repository;

import com.jcohy.sample.spring_cloud.provider.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author fangliangsheng
 */
public interface StorageRepository extends JpaRepository<Storage, String> {

	Storage findByCommodityCode(String commodityCode);

}
