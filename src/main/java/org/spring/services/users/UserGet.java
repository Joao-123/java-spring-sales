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
public class UserGet implements ServicesStrategy {

    /**
     * Constructor.
     */
    public UserGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(HelperUser.getEntity()))
                .setData(HelperUserList.getList());
        return response;
    }
}
