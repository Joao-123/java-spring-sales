package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;

/**
 * Service
 */
public class StrategyServiceItemGetById implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceItemGetById() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (Item item : HelperItem.getList()) {
            if (item.getId().equals(HelperItem.getId())) {
                HelperItem.getEmptyListHelper().add(item);
                return ResponseBuilderItem.getResponseOkForGetById();
            }
        }
        return ResponseBuilderItem.getResponseNotFound();
    }
}
