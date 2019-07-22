package org.spring.services.items;

import org.spring.models.Item;
import org.spring.repository.RepositoryItem;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Project Delete.
 */
@Service
public class StrategyServiceItemDelete implements StrategyResponse {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperItem.getEntity()))
                .setData(null);
        if (repositoryItem.findById(HelperItem.getId()).orElse(null) != null) {
            response
                    .setHttpStatus(HttpStatus.OK)
                    .getBody()
                    .setTextMessage(MessageManager.deletedSuccessfully(HelperItem.getEntity()))
                    .setData(null);
            repositoryItem.deleteById(HelperItem.getId());
        }
        return response;
    }
}
