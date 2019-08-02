package org.spring.services.users;

import org.spring.responses.ResponseBuilderUser;
import org.spring.services.ServicesStrategy;
import org.spring.responses.Response;


/**
 * Service.
 */
public class StrategyServiceUserGet implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceUserGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        return ResponseBuilderUser.getResponseOkForGet();
    }
}
