package org.spring.services.items;

import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
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
        HelperItemList
                .getResponse()
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperItemList.getEntity()))
                .setData(null);
        for (int i = 0; i < HelperItemList.getModelProjectList().size(); i++) {
            if (HelperItemList.getModelProjectList().get(i).getId().equals(HelperItem.getId())) {
                HelperItemList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.deletedSuccessfully(HelperItemList.getEntity()));
                HelperItemList.getModelProjectList().remove(i);
            }
        }
        return HelperItemList.getResponse();
    }
}
