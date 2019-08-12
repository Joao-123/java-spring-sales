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
public class StrategyServiceItemGetById implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Item item = repositoryItem.findById(HelperItem.getId()).orElse(null);
        if (item != null) {
            HelperItem.getEmptyList().add(item);
            return ResponseBuilderItem.getResponseOkForGet();
        } else {
            return ResponseBuilderItem.getResponseNotFound();
        }
    }
}
