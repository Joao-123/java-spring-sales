package org.spring.services.users;

import org.spring.helpers.HelperUser;
import org.spring.models.User;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.ServicesStrategy;
import org.spring.responses.Response;

/**
 * Service.
 */
public class StrategyServiceUserPost implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceUserPost() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (User user : HelperUser.getList()) {
            if (user.getId().equals(HelperUser.getEntity().getId())) {
                return ResponseBuilderUser.getResponseConflict();
            }
        }
        HelperUser.getList().add(HelperUser.getEntity());
        return ResponseBuilderUser.getResponseOkForPost();
    }
}
