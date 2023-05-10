package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path = "courses")
public interface CourseRepository extends CrudRepository<Course, Long> {
    public Set<Course> findByLevel(String level);
}
