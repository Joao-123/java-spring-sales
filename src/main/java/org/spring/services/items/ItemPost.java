package org.spring.services.items;

import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.springframework.http.HttpStatus;

/**
 * Project Post.
 */
public class ItemPost implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperItemList
                .getResponse()
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(MessageManager.createdSuccessfully(HelperItemList.getEntity()))
                .setData(null);
        HelperItemList.getModelProjectList().add(HelperItem.getModelProject());
        return HelperItemList.getResponse();
    }
}
