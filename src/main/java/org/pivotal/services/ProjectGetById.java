package org.pivotal.services;

import org.pivotal.models.ModelProject;
import org.pivotal.support.MessageManager;
import org.pivotal.support.Response;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Get by Id.
 */
public class ProjectGetById implements StrategyResponse {

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
        for (ModelProject modelProject : HelperProjectList.getModelProjectList()) {
            if (modelProject.getId().equals(HelperProject.getId())) {
                List<ModelProject> newModelProjectList = new ArrayList<>();
                newModelProjectList.add(modelProject);
                HelperProjectList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.getSuccessfully(HelperProjectList.getEntity()))
                        .setData(newModelProjectList);
            }
        }
        return HelperProjectList.getResponse();
    }
}
