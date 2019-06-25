package org.pivotal.services;

import org.pivotal.support.MessageManager;
import org.pivotal.support.Response;
import org.springframework.http.HttpStatus;

/**
 * Project Delete.
 */
public class ProjectDelete implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperProjectList
                .getResponse()
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperProjectList.getEntity()))
                .setData(null);
        for (int i = 0; i < HelperProjectList.getModelProjectList().size(); i++) {
            if (HelperProjectList.getModelProjectList().get(i).getId().equals(HelperProject.getId())) {
                HelperProjectList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.deletedSuccessfully(HelperProjectList.getEntity()));
                HelperProjectList.getModelProjectList().remove(i);
            }
        }
        return HelperProjectList.getResponse();
    }
}
