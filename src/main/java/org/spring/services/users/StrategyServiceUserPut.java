package org.spring.services.users;

import org.spring.helpers.HelperUser;
import org.spring.models.User;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.ServicesStrategy;
import org.spring.responses.Response;

/**
 * Service.
 */
public class StrategyServiceUserPut implements ServicesStrategy {

    /**
     * Constructor.
     */
    public StrategyServiceUserPut() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        for (User currentUser : HelperUser.getList()) {
            if (currentUser.getId().equals(HelperUser.getId())) {
                currentUser.setId(HelperUser.getEntity().getId());
                currentUser.setPassword(HelperUser.getEntity().getPassword());
                currentUser.setName(HelperUser.getEntity().getName());
                currentUser.setLastName(HelperUser.getEntity().getLastName());
                currentUser.setBirthDate(HelperUser.getEntity().getBirthDate());
                currentUser.setEmail(HelperUser.getEntity().getEmail());
                currentUser.setType(HelperUser.getEntity().getType());
                HelperUser.getList().add(currentUser);
                return ResponseBuilderUser.getResponseOkForPut();
            }
        }
        return ResponseBuilderUser.getResponseNotFound();
    }
}
