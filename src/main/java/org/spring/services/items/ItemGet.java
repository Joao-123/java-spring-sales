package org.spring.services.items;

import org.spring.models.Item;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.http.HttpStatus;


/**
 * Projects Get All .
 */
public class ItemGet implements StrategyResponse {

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
                .setTextMessage(MessageManager.getSuccessfully(HelperItemList.getEntity()))
                .setData(HelperItemList.getModelProjectList());
        return response;
    }
}
