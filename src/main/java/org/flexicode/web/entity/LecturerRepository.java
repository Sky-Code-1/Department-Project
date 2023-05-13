package org.flexicode.web.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    public List<Lecturer> findAll();

    public Lecturer findByFirstnameIgnoreCaseAndLastnameIgnoreCase(String firstname, String lastname);

    public Lecturer findByEmailIgnoreCase(String email);
}
