package org.spring.services.users;

import org.spring.models.User;
import org.spring.services.ServicesStrategy;
import org.spring.responses.ResponseMessage;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.springframework.http.HttpStatus;

/**
 * Class.
 */
public class UserPost implements ServicesStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(HelperUser.getEntity()))
                .setData(null);
        HelperUserList.getList().add(HelperUser.getUser());
        return response;
    }
}
