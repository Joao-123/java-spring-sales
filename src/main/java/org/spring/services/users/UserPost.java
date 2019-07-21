package org.spring.services.users;

import org.spring.models.User;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.http.HttpStatus;

/**
 * Class.
 */
public class UserPost implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(MessageManager.createdSuccessfully(HelperUser.getEntity()))
                .setData(null);
        HelperUserList.getList().add(HelperUser.getUser());
        return response;
    }
}
