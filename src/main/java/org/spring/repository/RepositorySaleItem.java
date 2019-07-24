package org.spring.repository;

import org.spring.models.SaleItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface.
 */
public interface RepositorySaleItem extends CrudRepository<SaleItem, Integer> {
}
