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
 * Project Post.
 */
@Service
public class StrategyServiceItemPost implements StrategyResponse {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        HelperItem.getEmptyList().add(HelperItem.getItem());
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(MessageManager.createdSuccessfully(HelperItem.getEntity()))
                .setData(HelperItem.getList());
        repositoryItem.save(HelperItem.getItem());
        return response;
    }
}
