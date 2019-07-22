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
 * Projects Get All .
 */
@Service
public class StrategyServiceItemGet implements StrategyResponse {

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * Constructor.
     */
    public StrategyServiceItemGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<Item> response = ResponseManager.getResponseItem();
        Iterable<Item> iterable = this.repositoryItem.findAll();
        HelperItem.getEmptyList();
        iterable.forEach(HelperItem.getList()::add);
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(MessageManager.getSuccessfully(HelperItem.getEntity()))
                .setData(HelperItem.getList());
        return response;
    }
}
