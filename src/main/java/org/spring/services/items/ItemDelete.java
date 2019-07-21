package org.spring.services.items;

import org.spring.models.Item;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.http.HttpStatus;

/**
 * Project Delete.
 */
public class ItemDelete implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperItemList.getEntity()))
                .setData(null);
        for (int i = 0; i < HelperItemList.getModelProjectList().size(); i++) {
            if (HelperItemList.getModelProjectList().get(i).getId().equals(HelperItem.getId())) {
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.deletedSuccessfully(HelperItemList.getEntity()));
                HelperItemList.getModelProjectList().remove(i);
            }
        }
        return response;
    }
}
