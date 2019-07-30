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
 * Project Put.
 */
public class ItemPut implements ServicesStrategy {

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
        for (Item currentItem : HelperItemList.getModelProjectList()) {
            if (currentItem.getId().equals(HelperItem.getId())) {
                currentItem.setId(HelperItem.getEntity().getId());
                currentItem.setName(HelperItem.getEntity().getName());
                // newItemList It's just to show the edited one.
                List<Item> newItemList = new ArrayList<>();
                newItemList.add(currentItem);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(ResponseMessage.updatedSuccessfully(HelperItemList.getEntity()))
                        .setData(newItemList);
            }
        }
        return response;
    }
}
