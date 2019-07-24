package org.spring.services.users;

import org.spring.models.Sale;
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
public class StrategyServiceUserDelete implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryUser.findById(HelperUser.getId()).orElse(null) != null) {
            List<Sale> listSales = this.repositorySale.findSalesRelatedWithUser(HelperUser.getId());
            if (listSales.isEmpty()) {
                repositoryUser.deleteById(HelperUser.getId());
                return ResponseBuilderUser.getResponseOkForDelete();
            }
            return ResponseBuilderUser.getResponseConflictEntityHasRelations();
        }
        return ResponseBuilderUser.getResponseNotFound();

    }
}
