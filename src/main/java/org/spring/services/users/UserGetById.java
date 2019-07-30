package org.spring.services.users;

import org.spring.models.User;
import org.spring.services.ServicesStrategy;
import org.spring.responses.ResponseMessage;
import org.spring.responses.Response;
import org.spring.responses.ResponseManager;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Class.
 */
public class UserGetById implements ServicesStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(ResponseMessage.getNotContent(HelperUser.getEntity()))
                .setData(null);
        for (User user : HelperUserList.getList()) {
            if (user.getId().equals(HelperUser.getId())) {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(ResponseMessage.getSuccessfully(HelperUser.getEntity()))
                        .setData(newList);
            }
        }
        return response;
    }
}
