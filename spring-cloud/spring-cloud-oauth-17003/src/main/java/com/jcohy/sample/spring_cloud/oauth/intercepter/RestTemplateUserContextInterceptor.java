package com.jcohy.sample.spring_cloud.oauth.intercepter;

import com.jcohy.sample.spring_cloud.oauth.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		User user = UserContextHolder.currentUser();
		request.getHeaders().add("x-user-id", user.getUserId());
		request.getHeaders().add("x-user-name", user.getUserName());
		request.getHeaders().add("x-user-serviceName", request.getURI().getHost());
		return execution.execute(request, body);
	}

}
