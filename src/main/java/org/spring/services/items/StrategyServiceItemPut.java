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
public class StrategyServiceItemPut implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryItem.findById(HelperItem.getId()).orElse(null) != null) {
            HelperItem.getItem().setId(HelperItem.getId());
            repositoryItem.save(HelperItem.getItem());
            HelperItem.getEmptyList().add(HelperItem.getItem());
            return ResponseBuilderItem.getResponseOkForPut();
        } else {
            return ResponseBuilderItem.getResponseNotFound();
        }
    }
}
