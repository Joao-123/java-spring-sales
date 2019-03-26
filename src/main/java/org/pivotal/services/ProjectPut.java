package org.pivotal.services;

import org.pivotal.models.ModelProject;
import org.pivotal.support.MessageManager;
import org.pivotal.support.Response;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * Project Put.
 */
public class ProjectPut implements StrategyResponse {

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
        for (ModelProject currentModelProject : HelperProjectList.getModelProjectList()) {
            if (currentModelProject.getId().equals(HelperProject.getId())) {
                currentModelProject.setId(HelperProject.getModelProject().getId());
                currentModelProject.setName(HelperProject.getModelProject().getName());
                // newModelProjectList It's just to show the edited one.
                List<ModelProject> newModelProjectList = new ArrayList<>();
                newModelProjectList.add(currentModelProject);
                HelperProjectList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.updatedSuccessfully(HelperProjectList.getEntity()))
                        .setData(newModelProjectList);
            }
        }
        return HelperProjectList.getResponse();
    }
}
