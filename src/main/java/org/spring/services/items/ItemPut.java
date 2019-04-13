package org.spring.services.items;

import org.spring.models.Item;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * Project Put.
 */
public class ItemPut implements StrategyResponse {

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
        for (Item currentItem : HelperItemList.getModelProjectList()) {
            if (currentItem.getId().equals(HelperItem.getId())) {
                currentItem.setId(HelperItem.getModelProject().getId());
                currentItem.setName(HelperItem.getModelProject().getName());
                // newItemList It's just to show the edited one.
                List<Item> newItemList = new ArrayList<>();
                newItemList.add(currentItem);
                HelperItemList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.updatedSuccessfully(HelperItemList.getEntity()))
                        .setData(newItemList);
            }
        }
        return HelperItemList.getResponse();
    }
}
