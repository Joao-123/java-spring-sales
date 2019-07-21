package org.spring.services.users;

import org.spring.models.User;
import org.spring.repository.RepositoryUser;
import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.spring.support.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


/**
 * Class.
 */
@Service
public class StrategyServiceUserGetById implements StrategyResponse {

    @Autowired
    private RepositoryUser repositoryUser;

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
        User user = repositoryUser.findById(HelperUser.getId()).orElse(null);
        if (user != null) {
            HelperUser.getEmptyList().add(user);
            response
                    .setHttpStatus(HttpStatus.OK)
                    .getBody()
                    .setTextMessage(MessageManager.getSuccessfully(HelperUser.getEntity()))
                    .setData(HelperUser.getList());
        }
        return response;
    }
}
