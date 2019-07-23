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
public class UserDelete implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperUser.getEntity()))
                .setData(null);
        for (int i = 0; i < HelperUserList.getList().size(); i++) {
            if (HelperUserList.getList().get(i).getId().equals(HelperUser.getId())) {
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.deletedSuccessfully(HelperUser.getEntity()));
                HelperUserList.getList().remove(i);
            }
        }
        return response;
    }
}
