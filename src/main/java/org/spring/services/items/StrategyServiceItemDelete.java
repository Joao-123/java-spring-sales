package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.ServicesStrategy;

/**
 * Service.
 */
public class StrategyServiceItemDelete implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceItemDelete() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (int i = 0; i < HelperItem.getList().size(); i++) {
            if (HelperItem.getList().get(i).getId().equals(HelperItem.getId())) {
                HelperItem.getList().remove(i);
                return ResponseBuilderItem.getResponseOkForDelete();
            }
        }
        return ResponseBuilderItem.getResponseNotFound();
    }
}
