package com.jcohy.sample.spring_boot.rabbitmq;

import java.io.Serializable;
import java.util.Objects;

/**
 * 描述: .
 * <p>
 * Copyright © 2022
 * <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/2:16:14
 * @since 2022.04.0
 */
public class Order implements Serializable {

	private String userId;

	private String username;

	private String description;

	public Order() {
	}

	public Order(String userId, String username, String description) {
		this.userId = userId;
		this.username = username;
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public Order setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Order setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Order setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order) o;
		return Objects.equals(getUserId(), order.getUserId()) && Objects.equals(getUsername(), order.getUsername())
				&& Objects.equals(getDescription(), order.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserId(), getUsername(), getDescription());
	}

	@Override
	public String toString() {
		return "Order{" + "userId='" + userId + '\'' + ", username='" + username + '\'' + ", description='"
				+ description + '\'' + '}';
	}

}
