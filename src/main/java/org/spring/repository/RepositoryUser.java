package org.spring.repository;

import org.spring.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Interface.
 */
@Repository
public interface RepositoryUser extends CrudRepository<User, String> {

}
