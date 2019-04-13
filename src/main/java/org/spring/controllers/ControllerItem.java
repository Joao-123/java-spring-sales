package org.spring.controllers;

import org.spring.models.Item;
import org.spring.services.ServicesItem;
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
public class ControllerItem {

    @Autowired
    private ServicesItem serviceItem;

    /**
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_ITEMS)
    public ResponseEntity<Response> getAll() {
        Response response = serviceItem.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<Response> getById(final @PathVariable String id) {
        Response response = serviceItem.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param item item.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_ITEMS)
    public ResponseEntity<Response> add(final @RequestBody Item item) {
        Response response = serviceItem.add(item);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param item item.
     * @param id   Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<Response> update(final @RequestBody Item item, final @PathVariable String id) {
        Response response = serviceItem.update(item, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    /**
     * @param id Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<Response> delete(final @PathVariable String id) {
        Response response = serviceItem.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);

    }

}
