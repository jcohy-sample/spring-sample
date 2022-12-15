package com.jcohy.sample.spring_cloud.provider;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 */

public class CourseDto implements Serializable {

	private Long cid;

	private String cname;

	private Long tid;

	public CourseDto() {
	}

	public CourseDto(Long cid, String cname, Long tid) {
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

}
