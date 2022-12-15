package com.jcohy.sample.spring_cloud.provider.student.model;

import java.io.Serializable;

public class ScPk implements Serializable {

	private Long sid;

	private Long cid;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

}