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
public class StrategyServiceItemDelete implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryItem.findById(HelperItem.getId()).orElse(null) != null) {
            repositoryItem.deleteById(HelperItem.getId());
            return ResponseBuilderItem.getResponseOkForDelete();
        } else {
            return ResponseBuilderItem.getResponseNotFound();
        }
    }
}
