package org.spring.controllers;

import org.spring.models.Item;
import org.spring.services.ServicesItem;
import org.spring.support.Paths;
import org.spring.responses.Response;
import org.spring.responses.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseEntity<ResponseBody> getAll() {
        Response response = serviceItem.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
        Response response = serviceItem.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param item item.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_ITEMS)
    public ResponseEntity<ResponseBody> add(final @RequestBody @Valid Item item) {
        Response response = serviceItem.add(item);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param item item.
     * @param id   Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> update(final @RequestBody @Valid Item item, final @PathVariable Integer id) {
        Response response = serviceItem.update(item, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id Item id.
     * @return ResponseSingle.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
        Response response = serviceItem.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }

}
