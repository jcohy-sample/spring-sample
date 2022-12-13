package com.jcohy.sample.spring_cloud.provider.account.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account_tbl")
@DynamicUpdate
@DynamicInsert
public class Account {

	@Id
	private Long id;

	private String userId;

	private BigDecimal money;

	public Account() {
	}

	public Account(Long id, String userId, BigDecimal money) {
		this.id = id;
		this.userId = userId;
		this.money = money;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
