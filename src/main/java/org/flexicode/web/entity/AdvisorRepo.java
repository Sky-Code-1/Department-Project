package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AdvisorRepo extends CrudRepository<CourseAdvisor, Long> {


    public Optional<CourseAdvisor> findByLevel(String level);
}
