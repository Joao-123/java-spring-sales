package org.spring.services.users;

import org.spring.helpers.HelperUser;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.ServicesStrategy;
import org.spring.responses.Response;


/**
 * Service.
 */
public class StrategyServiceUserDelete implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceUserDelete() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (int i = 0; i < HelperUser.getList().size(); i++) {
            if (HelperUser.getList().get(i).getId().equals(HelperUser.getId())) {
                HelperUser.getList().remove(i);
                return ResponseBuilderUser.getResponseOkForDelete();
            }
        }
        return ResponseBuilderUser.getResponseNotFound();
    }
}
