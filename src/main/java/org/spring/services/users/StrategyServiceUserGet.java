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
public class StrategyServiceUserGet implements StrategyResponse {

    @Autowired
    private RepositoryUser repositoryUser;

    /**
     * Constructor.
     */
    public StrategyServiceUserGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Response<User> response = ResponseManager.getResponseUser();
        Iterable<User> iterable = this.repositoryUser.findAll();
        HelperUser.getEmptyList();
        iterable.forEach(HelperUser.getList()::add);
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(MessageManager.getSuccessfully(HelperUser.getEntity()))
                .setData(HelperUser.getList());
        return response;
    }
}
