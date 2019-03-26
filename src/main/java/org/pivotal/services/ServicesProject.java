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


    private StrategyManager strategyManager;

    /**
     * Constructor.
     */
    ServicesProject() {
        strategyManager = new StrategyManager();
    }

    /**
     * @return modelProjectList.
     */
    public Response getAllProject() {
        return strategyManager.getResponse(new ProjectGetAll());
    }

    /**
     * @param id ModelProject id.
     * @return ModelProject.
     */
    public Response getProjectById(final String id) {
        HelperProject.setId(id);
        return strategyManager.getResponse(new ProjectGetById());
    }

    /**
     * @param modelProject ModelProject.
     * @return Message.
     */
    public Response addProject(final ModelProject modelProject) {
        HelperProject.setModelProject(modelProject);
        return strategyManager.getResponse(new ProjectPost());
    }

    /**
     * @param modelProject ModelProject.
     * @param id           ModelProject id.
     * @return Message.
     */
    public Response updateProject(final ModelProject modelProject, final String id) {
        HelperProject.setId(id);
        HelperProject.setModelProject(modelProject);
        return strategyManager.getResponse(new ProjectPut());
    }

    /**
     * @param id ModelProject id.
     * @return Message.
     */
    public Response deleteProject(final String id) {
        HelperProject.setId(id);
        return strategyManager.getResponse(new ProjectDelete());
    }
}
