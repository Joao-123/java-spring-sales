package org.spring.repository;

import org.spring.models.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Interface.
 */
public interface RepositoryUser extends CrudRepository<User, String> {

}
