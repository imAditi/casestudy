package com.example.examtoolweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.examtoolweb.domain.Test;

/**
 * It is an interface Repository marks the specific class as a Data Access
 * Object It provides generic CRUD operation on a repository for a specific
 * type.
 * @author aditi.jain
 *
 */
@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
}
