package com.jcohy.sample.spring_cloud.teacher.repository;

import com.jcohy.sample.spring_cloud.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Teacher getByTname(String name);

}
