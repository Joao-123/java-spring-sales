package org.pivotal.services;

import org.pivotal.support.MessageManager;
import org.pivotal.support.Response;
import org.springframework.http.HttpStatus;


/**
 * Projects Get All .
 */
public class ProjectGetAll implements StrategyResponse {

    /**
     * Constructor.
     */
    ProjectGetAll() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperProjectList
                .getResponse()
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(MessageManager.getSuccessfully(HelperProjectList.getEntity()))
                .setData(HelperProjectList.getModelProjectList());
        return HelperProjectList.getResponse();
    }

}
