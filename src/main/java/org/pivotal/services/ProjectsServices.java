package org.pivotal.services;

import java.util.ArrayList;
import java.util.List;


import org.pivotal.models.Project;
import org.pivotal.models.ResponseData;
import org.pivotal.support.*;
import org.springframework.stereotype.Service;

/**
 * Projects Services.
 */
@Service
public class ProjectsServices {

    private static final String ENTITY = "project";

    private List<ResponseData> projectList;

    /**
     * Constructor.
     */
    ProjectsServices() {
        projectList = new ArrayList<>();
    }

    /**
     * @return projectList.
     */
    public Response getAllProject() {
        ResponseList response = new ResponseList();
        response.setMessage(MessageManager.getSuccessfully(ENTITY));
        response.setResponseData(projectList);
        return response;
    }

    /**
     * @param id Project id.
     * @return Project.
     */
    public Response getProjectById(final String id) {
        ResponseSingle response = new ResponseSingle();
        response.setMessage(MessageManager.getNotContent(ENTITY));
        for (ResponseData project : projectList) {
            if (project.getId().equals(id)) {
                response.setResponseData(project);
                response.setMessage(MessageManager.getSuccessfully(ENTITY));
            }
        }
        return response;
    }

    /**
     * @param project Project.
     * @return Message.
     */
    public Response addProject(final Project project) {
        ResponseList response = new ResponseList();
        response.setMessage(MessageManager.getSuccessfully(ENTITY));
        response.setResponseData(projectList);
        projectList.add(project);
        return MessageManager.createdSuccessfully(ENTITY);
    }

    /**
     * @param project Project.
     * @param id      Project id.
     * @return Message.
     */
    public Message updateProject(final Project project, final String id) {
        for (Project currentProject : projectList) {
            if (currentProject.getId().equals(id)) {
                currentProject.setId(project.getId());
                currentProject.setName(project.getName());
                return MessageManager.updatedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }

    /**
     * @param id Project id.
     * @return Message.
     */
    public Message deleteProject(final String id) {
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getId().equals(id)) {
                projectList.remove(i);
                return MessageManager.deletedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }
}
