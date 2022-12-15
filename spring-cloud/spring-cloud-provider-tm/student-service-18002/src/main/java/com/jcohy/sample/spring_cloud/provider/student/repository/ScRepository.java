package com.jcohy.sample.spring_cloud.provider.student.repository;

import com.jcohy.sample.spring_cloud.provider.student.model.Sc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 */

public interface ScRepository extends JpaRepository<Sc, Long> {

	@Query(value = "select s.sid,s.cid,s.score from sc s where sid =?1", nativeQuery = true)
	List<Sc> findScoreById(Long id);

}
