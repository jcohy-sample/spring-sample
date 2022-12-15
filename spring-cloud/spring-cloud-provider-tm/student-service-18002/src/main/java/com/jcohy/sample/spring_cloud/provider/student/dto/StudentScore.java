package com.jcohy.sample.spring_cloud.provider.student.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 */

public class StudentScore implements Serializable {

	private String sname;

	private List<Map<String, Object>> mapList;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Map<String, Object>> getMapList() {
		return mapList;
	}

	public void setMapList(List<Map<String, Object>> mapList) {
		this.mapList = mapList;
	}

}
