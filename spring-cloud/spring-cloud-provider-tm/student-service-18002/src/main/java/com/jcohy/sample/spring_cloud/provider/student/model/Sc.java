package com.jcohy.sample.spring_cloud.provider.student.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sc")
@IdClass(ScPk.class)
public class Sc implements Serializable {

	@Id
	private Long sid;

	@Id
	private Long cid;

	@Column(name = "score", nullable = false)
	private Integer score;

	public Sc() {
	}

	public Sc(Long sid, Long cid, Integer score) {
		this.sid = sid;
		this.cid = cid;
		this.score = score;
	}

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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
