package org.spring.services.users;

import org.spring.models.User;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Class.
 */
public class UserPut implements StrategyResponse {

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.NO_CONTENT)
                .getBody()
                .setTextMessage(MessageManager.getNotContent(HelperUser.getEntity()))
                .setData(null);
        for (User currentUser : HelperUserList.getList()) {
            if (currentUser.getId().equals(HelperUser.getId())) {
                currentUser.setId(HelperUser.getUser().getId());
                currentUser.setName(HelperUser.getUser().getName());
                // newModelProjectList It's just to show the edited one.
                List<User> newModelProjectList = new ArrayList<>();
                newModelProjectList.add(currentUser);
                response
                        .setHttpStatus(HttpStatus.OK)
                        .getBody()
                        .setTextMessage(MessageManager.updatedSuccessfully(HelperUser.getEntity()))
                        .setData(newModelProjectList);
            }
        }
        return response;
    }
}
