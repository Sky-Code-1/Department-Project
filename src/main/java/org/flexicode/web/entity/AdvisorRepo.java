package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvisorRepo extends CrudRepository<CourseAdvisor, Long> {


    public Optional<CourseAdvisor> findByLevel(String level);
}
