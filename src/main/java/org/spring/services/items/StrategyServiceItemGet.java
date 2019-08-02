package org.spring.services.items;

import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;


/**
 * Service.
 */
public class StrategyServiceItemGet implements ServicesStrategy {

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
        return ResponseBuilderItem.getResponseOkForGet();
    }
}
