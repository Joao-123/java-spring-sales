package org.spring.services.users;

import org.spring.helpers.HelperUser;
import org.spring.models.User;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.ServicesStrategy;
import org.spring.responses.Response;

/**
 * Service.
 */
public class StrategyServiceUserGetById implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceUserGetById() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (User user : HelperUser.getList()) {
            if (user.getId().equals(HelperUser.getId())) {
                HelperUser.getEmptyListHelper().add(user);
                return ResponseBuilderUser.getResponseOkForGetById();
            }
        }
        return ResponseBuilderUser.getResponseNotFound();
    }
}
