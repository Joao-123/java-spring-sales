package org.spring.responses;

import org.spring.models.Sale;
import org.spring.services.Sales.HelperSale;
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
                .setTextMessage(ResponseMessage.getSuccessfully(HelperSale.getEntity()))
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
                .setTextMessage(ResponseMessage.createdSuccessfully(HelperSale.getEntity()))
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
                .setTextMessage(ResponseMessage.updatedSuccessfully(HelperSale.getEntity()))
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
                .setTextMessage(ResponseMessage.deletedSuccessfully(HelperSale.getEntity()))
                .setData(null);
        return response;
    }

    /**
     * @return responses.
     */
     public static Response<Sale> getResponseConflict() {
        Response<Sale> response = ResponseManager.getResponseSale();
        response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityAlreadyExist(HelperSale.getEntity()))
                .setData(HelperSale.getList());
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
                .setTextMessage(ResponseMessage.getNotContent(HelperSale.getEntity()))
                .setData(null);
        return response;
    }
}
