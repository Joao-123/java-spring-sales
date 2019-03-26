package org.pivotal.services;

import org.pivotal.support.MessageManager;
import org.pivotal.support.Response;
import org.springframework.http.HttpStatus;

/**
 * Project Post.
 */
public class ProjectPost implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperProjectList
                .getResponse()
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(MessageManager.createdSuccessfully(HelperProjectList.getEntity()))
                .setData(null);
        HelperProjectList.getModelProjectList().add(HelperProject.getModelProject());
        return HelperProjectList.getResponse();
    }
}
