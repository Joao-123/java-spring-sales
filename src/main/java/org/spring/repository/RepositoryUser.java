package org.spring.repository;

import org.spring.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface.
 */
public interface RepositoryUser extends CrudRepository<User, String> {

    /*
    public List<User> findAll();


    public User findOne(String id);


    public User save(User user);


    public void delete(User user);*/

}
