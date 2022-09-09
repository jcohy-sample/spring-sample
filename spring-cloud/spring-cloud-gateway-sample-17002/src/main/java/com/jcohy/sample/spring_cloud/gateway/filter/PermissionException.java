package com.jcohy.sample.spring_cloud.gateway.filter;

public class PermissionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionException(String msg) {
		super(msg);
	}

}
