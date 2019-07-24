package org.spring.controllers;

import org.spring.models.Sale;
import org.spring.responses.Response;
import org.spring.responses.ResponseBody;
import org.spring.services.ServicesSale;
import org.spring.support.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RestController.
 */
@Controller
public class ControllerSale {

    @Autowired
    private ServicesSale servicesSale;

    /**
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS)
    public ResponseEntity<ResponseBody> getAll() {
        Response response = servicesSale.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id id.
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
        Response response = servicesSale.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param sale sale.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS)
    public ResponseEntity<ResponseBody> add(final @RequestBody Sale sale) {
        Response response = servicesSale.add(sale);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param sale sale.
     * @param id   id.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<ResponseBody> update(final @RequestBody Sale sale, final @PathVariable Integer id) {
        Response response = servicesSale.update(sale, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id id.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_USERS_WITH_ID)
    public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
        Response response = servicesSale.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }
}
