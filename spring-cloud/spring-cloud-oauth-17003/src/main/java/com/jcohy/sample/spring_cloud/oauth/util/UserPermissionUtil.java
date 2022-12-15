package com.jcohy.sample.spring_cloud.oauth.util;

import com.jcohy.sample.spring_cloud.oauth.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserPermissionUtil {

	/**
	 * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
	 * @param user user
	 * @param request request
	 * @return /
	 */
	public static boolean verify(User user, HttpServletRequest request) {
		String url = request.getHeader("x-user-serviceName");
		if (!Objects.isNull(user)) {
			List<String> str = user.getAllowPermissionService();
			for (String permissionService : str) {
				if (url.equalsIgnoreCase(permissionService)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
	 * @param user user
	 */
	public static void permission(User user) {

		if ("admin".equals(user.getUserName())) {
			List<String> allowPermissionService = new ArrayList<>();
			allowPermissionService.add("provider-teacher");
			allowPermissionService.add("provider-student");
			allowPermissionService.add("provider-course");
			user.setAllowPermissionService(allowPermissionService);
		}
		else if ("spring".equals(user.getUserName())) {
			List<String> allowPermissionService = new ArrayList<String>();
			allowPermissionService.add("provider-student");
			allowPermissionService.add("provider-course");
			user.setAllowPermissionService(allowPermissionService);
		}
		else {
			List<String> allowPermissionService = new ArrayList<>();
			user.setAllowPermissionService(allowPermissionService);
		}
	}

}
