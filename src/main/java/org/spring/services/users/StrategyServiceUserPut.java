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
public class StrategyServiceUserPut implements StrategyResponse {

    @Autowired
    private RepositoryUser repositoryUser;

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
        if (repositoryUser.findById(HelperUser.getId()).orElse(null) != null) {
            repositoryUser.save(HelperUser.getUser());
            HelperUser.getEmptyList().add(HelperUser.getUser());
            response
                    .setHttpStatus(HttpStatus.OK)
                    .getBody()
                    .setTextMessage(MessageManager.updatedSuccessfully(HelperUser.getEntity()))
                    .setData(HelperUser.getList());
        }
        return response;
    }
}
