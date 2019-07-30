package org.spring.services;

import org.spring.responses.Response;

/**
 * Strategy Manager.
 */
public class ServicesStrategyManager {

    /**
     * @param servicesStrategy strategy Response.
     * @return Response.
     */
    public Response getResponse(final ServicesStrategy servicesStrategy) {
        return servicesStrategy.getResponse();
    }
}
