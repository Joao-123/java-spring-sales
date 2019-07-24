package org.spring.repository;

import org.spring.models.Sale;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface.
 */
public interface RepositorySale extends CrudRepository<Sale, Integer> {
}
