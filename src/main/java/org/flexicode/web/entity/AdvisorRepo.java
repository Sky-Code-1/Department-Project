package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface AdvisorRepo extends CrudRepository<CourseAdvisor, Long> {
    public List<CourseAdvisor> findAll();
    public Optional<CourseAdvisor> findByLevel(String level);
}
