package com.jcohy.sample.spring_cloud.provider;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 */

public class TeacherDto implements Serializable {

	private Long tid;

	private String tname;

	public TeacherDto() {
	}

	public TeacherDto(Long tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
