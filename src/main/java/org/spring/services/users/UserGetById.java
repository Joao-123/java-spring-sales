package org.spring.services.users;

import org.spring.models.User;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Class.
 */
public class UserGetById implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperUserList
                .getResponse()
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperUser.getEntity()))
                .setData(null);
        for (User user : HelperUserList.getList()) {
            if (user.getId().equals(HelperUser.getId())) {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                HelperUserList
                        .getResponse()
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.getSuccessfully(HelperUser.getEntity()))
                        .setData(newList);
            }
        }
        return HelperUserList.getResponse();
    }
}
