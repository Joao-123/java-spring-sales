package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;

/**
 * Service
 */
public class StrategyServiceItemPost implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceItemPost() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperItem.getList().add(HelperItem.getEntity());
        return ResponseBuilderItem.getResponseOkForPost();
    }
}
