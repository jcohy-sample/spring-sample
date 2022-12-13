package com.jcohy.sample.spring_cloud.provider.account.repository;

import com.jcohy.sample.spring_cloud.provider.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author fangliangsheng
 * @date 2019/3/28
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUserId(String userId);

}
