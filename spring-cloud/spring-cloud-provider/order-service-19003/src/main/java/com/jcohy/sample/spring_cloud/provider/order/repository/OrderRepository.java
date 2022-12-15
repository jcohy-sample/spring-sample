package com.jcohy.sample.spring_cloud.provider.order.repository;

import com.jcohy.sample.spring_cloud.provider.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author fangliangsheng
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
