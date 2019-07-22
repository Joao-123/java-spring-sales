package org.spring.repository;

import org.spring.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryItem extends CrudRepository<Item, String> {
}
