package org.spring.services.users;

import org.spring.models.Sale;
import org.spring.models.User;
import org.spring.repository.RepositorySale;
import org.spring.repository.RepositoryUser;
import org.spring.responses.ResponseBuilderUser;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyServiceUserPut implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        User user = repositoryUser.findById(HelperUser.getId()).orElse(null);
        HelperUser.getEmptyList().add(HelperUser.getEntity());
        // If user not exist.
        if (user != null) {
            // If user have not equals ids.
            if (!HelperUser.getId().equals(HelperUser.getEntity().getId())) {
                List<Sale> listSales = this.repositorySale.findSalesRelatedWithUser(HelperUser.getId());
                // If user not have a relations
                if (listSales.isEmpty()) {
                    repositoryUser.deleteById(HelperUser.getId());
                    repositoryUser.save(HelperUser.getEntity());
                    return ResponseBuilderUser.getResponseOkForPut();
                }
                return ResponseBuilderUser.getResponseConflictEntityHasRelations();
            }
            repositoryUser.save(HelperUser.getEntity());
            return ResponseBuilderUser.getResponseOkForPut();
        }
        return ResponseBuilderUser.getResponseNotFound();
    }
}
