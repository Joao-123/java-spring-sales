package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.models.Item;
import org.spring.repository.RepositoryItem;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyServiceItemGet implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * Constructor.
     */
    public StrategyServiceItemGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Iterable<Item> iterable = this.repositoryItem.findAll();
        HelperItem.getEmptyList();
        iterable.forEach(HelperItem.getList()::add);
        return ResponseBuilderItem.getResponseOkForGet();
    }
}
