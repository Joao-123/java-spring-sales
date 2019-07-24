package org.spring.repository;

import org.spring.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Class.
 */
@Repository
public interface RepositoryItem extends CrudRepository<Item, Integer> {

}
