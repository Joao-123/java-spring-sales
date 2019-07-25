package org.spring.responses;

import org.spring.models.Sale;
import org.spring.services.sales.HelperSale;
import org.springframework.http.HttpStatus;

/**
 * Response Builder.
 */
public final class ResponseBuilderSale {

    /**
     * Constructor.
     */
    private ResponseBuilderSale() {

    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseOkForGet() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(HelperSale.getEntityName()))
                .setData(HelperSale.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseOkForPost() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(HelperSale.getEntityName()))
                .setData(HelperSale.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseOkForPut() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.updatedSuccessfully(HelperSale.getEntityName()))
                .setData(HelperSale.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseOkForDelete() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.deletedSuccessfully(HelperSale.getEntityName()))
                .setData(HelperSale.getEmptyList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseNotFound() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(ResponseMessage.entityNotFound(HelperSale.getEntityName()))
                .setData(HelperSale.getEmptyList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<Sale> getResponseConflictEntityHasRelations() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityHasRelation(HelperSale.getEntityName()))
                .setData(HelperSale.getEmptyList());
        return response;
    }
}
