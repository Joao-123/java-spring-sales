package org.spring.services.items;

import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.spring.responses.ResponseMessage;
import org.spring.services.ServicesStrategy;
import org.springframework.http.HttpStatus;

/**
 * Project Delete.
 */
public class ItemDelete implements ServicesStrategy {

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
        for (int i = 0; i < HelperItemList.getModelProjectList().size(); i++) {
            if (HelperItemList.getModelProjectList().get(i).getId().equals(HelperItem.getId())) {
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(ResponseMessage.deletedSuccessfully(HelperItemList.getEntity()));
                HelperItemList.getModelProjectList().remove(i);
            }
        }
        return response;
    }
}
