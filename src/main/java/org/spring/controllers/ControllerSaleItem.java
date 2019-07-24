package org.spring.controllers;

import org.spring.models.SaleItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBody;
import org.spring.services.ServicesSaleItem;
import org.spring.support.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RestController.
 */
public class ControllerSaleItem {

    @Autowired
    private ServicesSaleItem servicesSaleItem;

    /**
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_SALE_ITEMS)
    public ResponseEntity<ResponseBody> getAll() {
        Response response = servicesSaleItem.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id id.
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_SALE_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
        Response response = servicesSaleItem.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param saleItem saleItem.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_SALE_ITEMS)
    public ResponseEntity<ResponseBody> add(final @RequestBody SaleItem saleItem) {
        Response response = servicesSaleItem.add(saleItem);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param saleItem saleItem.
     * @param id       id.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_SALE_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> update(final @RequestBody SaleItem saleItem, final @PathVariable Integer id) {
        Response response = servicesSaleItem.update(saleItem, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id id.
     * @return Response entity..
     */
    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_SALE_ITEMS_WITH_ID)
    public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
        Response response = servicesSaleItem.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }
}
