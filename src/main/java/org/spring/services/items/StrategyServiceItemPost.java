package org.spring.services.items;

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
public class StrategyServiceItemPost implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperItem.getEmptyList().add(HelperItem.getItem());
        repositoryItem.save(HelperItem.getItem());
        return ResponseBuilderItem.getResponseOkForPost();
    }
}
