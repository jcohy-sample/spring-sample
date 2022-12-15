package com.jcohy.sample.spring_cloud.provider.course.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcohy.sample.spring_cloud.provider.CourseDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;

	@Column(name = "cname")
	private String cname;

	@Column(name = "tid")
	private Long tid;

	public Course(String cname, Long tid) {
		this.cname = cname;
		this.tid = tid;
	}

	public Course() {
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

	@Override
	public String toString() {
		return "Course{" + "cid=" + cid + ", cname='" + cname + '\'' + ", tid=" + tid + '}';
	}

	public static CourseDto ofDto(Course course) {
		CourseDto courseDto = new CourseDto(course.getCid(), course.getCname(), course.getTid());
		return courseDto;
	}

}
