package org.spring.controllers;

import org.spring.models.User;
import org.spring.services.ServicesUser;
import org.spring.support.Paths;
import org.spring.support.Response;
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
public class ControllerUser {

    @Autowired
    private ServicesUser servicesUser;

    /**
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS)
    public ResponseEntity<Response> getAll() {
        Response response = servicesUser.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id user id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<Response> getById(final @PathVariable String id) {
        Response response = servicesUser.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param user user.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS)
    public ResponseEntity<Response> add(final @RequestBody User user) {
        Response response = servicesUser.add(user);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param user user.
     * @param id   user id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<Response> update(final @RequestBody User user, final @PathVariable String id) {
        Response response = servicesUser.update(user, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<Response> delete(final @PathVariable String id) {
        Response response = servicesUser.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);

    }
}
