package com.jcohy.sample.spring_cloud.provider.account.repository;

import com.jcohy.sample.spring_cloud.provider.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author fangliangsheng
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUserId(String userId);

}
