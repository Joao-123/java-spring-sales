package org.spring.services.users;

import org.spring.helpers.HelperUser;
import org.spring.models.User;
import org.spring.repository.RepositoryUser;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyServiceUserGet implements StrategyService {

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
        Iterable<User> iterable = this.repositoryUser.findAll();
        HelperUser.getEmptyList();
        iterable.forEach(HelperUser.getList()::add);
        return ResponseBuilderUser.getResponseOkForGet();
    }
}
