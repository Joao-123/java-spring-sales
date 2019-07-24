package org.spring.services.users;

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
public class StrategyServiceUserDelete implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryUser.findById(HelperUser.getId()).orElse(null) != null) {
            repositoryUser.deleteById(HelperUser.getId());
            return ResponseBuilderUser.getResponseOkForDelete();
        } else {
            return ResponseBuilderUser.getResponseNotFound();
        }
    }
}
