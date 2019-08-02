package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;


/**
 * Service.
 */
public class StrategyServiceItemPut implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceItemPut() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (Item currentItem : HelperItem.getList()) {
            if (currentItem.getId().equals(HelperItem.getId())) {
                currentItem.setName(HelperItem.getEntity().getName());
                currentItem.setPrice(HelperItem.getEntity().getPrice());
                currentItem.setStock(HelperItem.getEntity().getStock());
                HelperItem.getList().add(currentItem);
                return ResponseBuilderItem.getResponseOkForPut();
            }
        }
        return ResponseBuilderItem.getResponseNotFound();
    }
}
