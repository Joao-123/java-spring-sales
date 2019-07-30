package org.spring.services.items;

import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.spring.responses.ResponseMessage;
import org.spring.services.ServicesStrategy;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Get by Id.
 */
public class ItemGetById implements ServicesStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(ResponseMessage.getNotContent(HelperItemList.getEntity()))
                .setData(null);
        for (Item item : HelperItemList.getModelProjectList()) {
            if (item.getId().equals(HelperItem.getId())) {
                List<Item> newItemList = new ArrayList<>();
                newItemList.add(item);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(ResponseMessage.getSuccessfully(HelperItemList.getEntity()))
                        .setData(newItemList);
            }
        }
        return response;
    }
}
