package org.spring.services.items;

import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.spring.responses.ResponseMessage;
import org.spring.services.ServicesStrategy;
import org.springframework.http.HttpStatus;


/**
 * Projects Get All .
 */
public class ItemGet implements ServicesStrategy {

    /**
     * Constructor.
     */
    public ItemGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(HelperItemList.getEntity()))
                .setData(HelperItemList.getModelProjectList());
        return response;
    }
}
