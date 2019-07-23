package org.spring.repository;

import org.spring.models.Item;
import org.springframework.data.repository.CrudRepository;


/**
 * Class.
 */
public interface RepositoryItem extends CrudRepository<Item, Integer> {

}
