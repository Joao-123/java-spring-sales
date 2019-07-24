package org.spring.services;

import org.spring.responses.Response;

/**
 * Strategy Manager.
 */
public class StrategyManager {

    /**
     * @param strategyServices strategy Response.
     * @return Response.
     */
    public Response getResponse(final StrategyService strategyServices) {
        return strategyServices.getResponse();
    }
}
