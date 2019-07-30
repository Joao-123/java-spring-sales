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
public class UserDelete implements ServicesStrategy {

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
        for (int i = 0; i < HelperUserList.getList().size(); i++) {
            if (HelperUserList.getList().get(i).getId().equals(HelperUser.getId())) {
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(ResponseMessage.deletedSuccessfully(HelperUser.getEntity()));
                HelperUserList.getList().remove(i);
            }
        }
        return response;
    }
}
