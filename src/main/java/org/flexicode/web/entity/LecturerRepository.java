package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    public List<Lecturer> findAll();
}
