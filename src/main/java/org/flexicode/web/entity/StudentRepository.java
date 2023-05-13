package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Long> {
    public List<Student> findAll();

    public List<Student> findByLevel(String level);
}
