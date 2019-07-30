package org.spring.services.items;

import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.spring.responses.ResponseMessage;
import org.spring.services.ServicesStrategy;
import org.springframework.http.HttpStatus;

/**
 * Project Post.
 */
public class ItemPost implements ServicesStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(HelperItemList.getEntity()))
                .setData(null);
        HelperItemList.getModelProjectList().add(HelperItem.getEntity());
        return response;
    }
}
