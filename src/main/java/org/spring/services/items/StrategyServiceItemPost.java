package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;
import org.spring.support.Magic;

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
        HelperItem.getEntity().setId(Magic.ONE_THOUSAND + HelperItem.getList().size());
        HelperItem.getList().add(HelperItem.getEntity());
        return ResponseBuilderItem.getResponseOkForPost();
    }
}
