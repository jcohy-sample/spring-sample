package com.jcohy.sample.spring_cloud.provider.account.controller;

import com.jcohy.sample.spring_cloud.provider.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author fangliangsheng
 */
@RestController
@RefreshScope
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Value("${user.name}")
	private String name;

	@Value("${message.prefix}")
	private String prefix;

	@RequestMapping("/debit")
	public Boolean debit(String userId, BigDecimal money) {
		accountService.debit(userId, money);
		// System.out.println("get user from nacos config :"+name);
		return true;
	}

	@GetMapping("/{username}")
	public String hello(@PathVariable(value = "username") String username) {
		return prefix + username + "!" + name;
	}

}
