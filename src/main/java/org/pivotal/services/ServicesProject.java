package org.pivotal.services;

import java.util.ArrayList;
import java.util.List;


import org.pivotal.models.ModelProject;
import org.pivotal.support.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Projects Services.
 */
@Service
public class ServicesProject {

    private static final String ENTITY = "project";

    private List<ModelProject> modelProjectList;
    private Response<ModelProject> response;

    /**
     * Constructor.
     */
    ServicesProject() {
        modelProjectList = new ArrayList<>();
        response = new Response<>();
    }

    /**
     * @return modelProjectList.
     */
    public Response getAllProject() {
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(MessageManager.getSuccessfully(ENTITY))
                .setData(modelProjectList);
        return response;
    }

    /**
     * @param id ModelProject id.
     * @return ModelProject.
     */
    public Response getProjectById(final String id) {
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(ENTITY))
                .setData(null);

        for (ModelProject modelProject : modelProjectList) {
            if (modelProject.getId().equals(id)) {
                List<ModelProject> newModelProjectList = new ArrayList<>();
                newModelProjectList.add(modelProject);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.getSuccessfully(ENTITY))
                        .setData(newModelProjectList);
            }
        }
        return response;
    }

    /**
     * @param modelProject ModelProject.
     * @return Message.
     */
    public Response addProject(final ModelProject modelProject) {
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(MessageManager.createdSuccessfully(ENTITY))
                .setData(null);
        modelProjectList.add(modelProject);
        return response;
    }

    /**
     * @param modelProject ModelProject.
     * @param id      ModelProject id.
     * @return Message.
     */
    public Response updateProject(final ModelProject modelProject, final String id) {
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(ENTITY))
                .setData(null);
        for (ModelProject currentModelProject : modelProjectList) {
            if (currentModelProject.getId().equals(id)) {
                List<ModelProject> newModelProjectList = new ArrayList<>();
                newModelProjectList.add(currentModelProject);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.updatedSuccessfully(ENTITY))
                        .setData(newModelProjectList);
            }
        }
        return response;
    }

    /**
     * @param id ModelProject id.
     * @return Message.
     */
    public Response deleteProject(final String id) {
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(ENTITY))
                .setData(null);
        for (int i = 0; i < modelProjectList.size(); i++) {
            if (modelProjectList.get(i).getId().equals(id)) {
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.deletedSuccessfully(ENTITY));
                modelProjectList.remove(i);
            }
        }
        return response;
    }
}
