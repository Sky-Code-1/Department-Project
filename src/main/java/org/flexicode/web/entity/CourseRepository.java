package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RepositoryRestResource(path = "courses")
public interface CourseRepository extends CrudRepository<Course, Long> {
    public Set<Course> findByLevel(String level);

    public List<Course> findByLevelStartsWithIgnoreCase(@NonNull String level);


    public Optional<Course> findCourseByCourseCode(String courseCode);
    public Optional<Course> findByCourseName(String CourseName);
    public List<Course> findAll();
}
