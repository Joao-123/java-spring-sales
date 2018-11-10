package org.pivotal.controllers;

import org.pivotal.models.ModelProject;
import org.pivotal.services.ServicesProject;
import org.pivotal.support.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 */
@RestController
public class ControllerProject {

    @Autowired
    private ServicesProject projectService;

    /**
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROJECTS)
    public ResponseEntity<Response> getAllProjects() {
        Response response = projectService.getAllProject();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id ModelProject id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<Response> getProjectById(final @PathVariable String id) {
        Response response = projectService.getProjectById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param modelProject modelProject.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_PROJECTS)
    public ResponseEntity<Response> postProject(final @RequestBody ModelProject modelProject) {
        Response response = projectService.addProject(modelProject);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param modelProject modelProject.
     * @param id           ModelProject id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<Response> updateProject(final @RequestBody ModelProject modelProject, final @PathVariable String id) {
        Response response = projectService.updateProject(modelProject, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id ModelProject id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<Response> deleteProject(final @PathVariable String id) {
        Response response = projectService.deleteProject(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);

    }

}
