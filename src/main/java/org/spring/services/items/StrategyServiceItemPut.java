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
 * Project Put.
 */
@Service
public class StrategyServiceItemPut implements StrategyResponse {

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
            HelperItem.getItem().setId(HelperItem.getId());
            repositoryItem.save(HelperItem.getItem());
            HelperItem.getEmptyList().add(HelperItem.getItem());
            response
                    .setHttpStatus(HttpStatus.OK)
                    .getBody()
                    .setTextMessage(MessageManager.updatedSuccessfully(HelperItem.getEntity()))
                    .setData(HelperItem.getList());
        }
        return response;
    }
}
