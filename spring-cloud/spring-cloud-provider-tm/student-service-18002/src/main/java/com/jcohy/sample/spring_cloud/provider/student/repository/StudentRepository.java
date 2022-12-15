package com.jcohy.sample.spring_cloud.provider.student.repository;

import com.jcohy.sample.spring_cloud.provider.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findStudentBySname(String sname);

}
