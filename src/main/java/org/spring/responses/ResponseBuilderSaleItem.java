package org.spring.responses;

import org.spring.models.SaleItem;
import org.spring.services.salesitems.HelperSaleItem;
import org.springframework.http.HttpStatus;

/**
 * Response Builder.
 */
public final class ResponseBuilderSaleItem {

    /**
     * Constructor.
     */
    private ResponseBuilderSaleItem() {

    }

    /**
     * @return responses.
     */
    public static Response<SaleItem> getResponseOkForGet() {
        Response<SaleItem> response = ResponseManager.getResponseSaleItem();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(HelperSaleItem.getEntityName()))
                .setData(HelperSaleItem.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<SaleItem> getResponseOkForPost() {
        Response<SaleItem> response = ResponseManager.getResponseSaleItem();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(HelperSaleItem.getEntityName()))
                .setData(HelperSaleItem.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<SaleItem> getResponseOkForPut() {
        Response<SaleItem> response = ResponseManager.getResponseSaleItem();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.updatedSuccessfully(HelperSaleItem.getEntityName()))
                .setData(HelperSaleItem.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<SaleItem> getResponseOkForDelete() {
        Response<SaleItem> response = ResponseManager.getResponseSaleItem();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.deletedSuccessfully(HelperSaleItem.getEntityName()))
                .setData(null);
        return response;
    }

    /**
     * @return responses.
     */
    public static Response<SaleItem> getResponseNotFound() {
        Response<SaleItem> response = ResponseManager.getResponseSaleItem();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(ResponseMessage.entityNotFound(HelperSaleItem.getEntityName()))
                .setData(null);
        return response;
    }
}
