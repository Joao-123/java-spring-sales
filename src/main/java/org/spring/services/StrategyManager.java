package org.spring.services;

import org.spring.support.Response;

/**
 * Strategy Manager.
 */
public class StrategyManager {

    /**
     * @param strategyResponse strategy Response.
     * @return Response.
     */
    public Response getResponse(final StrategyResponse strategyResponse) {
        return strategyResponse.getResponse();
    }
}
