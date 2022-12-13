package com.jcohy.sample.spring_cloud.provider.course.repository;

import com.jcohy.sample.spring_cloud.provider.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course getByCname(String name);

}
