package org.spring.services.users;

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
public class StrategyServiceUserPut implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        User user = repositoryUser.findById(HelperUser.getId()).orElse(null);
        if (user != null) {
            if (!HelperUser.getId().equals(HelperUser.getUser().getId())) {
                repositoryUser.deleteById(HelperUser.getId());
            }
            repositoryUser.save(HelperUser.getUser());
            HelperUser.getEmptyList().add(HelperUser.getUser());
            return ResponseBuilderUser.getResponseOkForPut();
        } else {
            return ResponseBuilderUser.getResponseNotFound();
        }
    }
}
