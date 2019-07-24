package org.spring.services.Sales;

import org.spring.models.User;
import org.spring.repository.RepositorySale;
import org.spring.repository.RepositoryUser;
import org.spring.responses.ResponseBuilderSale;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service.
 */
@Service
public class StrategyServiceSalePost implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    @Autowired
    private RepositoryUser repositoryUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperSale.getEmptyList().add(HelperSale.getSale());
        User client = repositoryUser.findById(HelperSale.getSale().getIdClient()).orElse(null);
        User seller = repositoryUser.findById(HelperSale.getSale().getIdSeller()).orElse(null);
        if (client != null && seller != null) {
            repositorySale.save(HelperSale.getSale());
            return ResponseBuilderSale.getResponseOkForPost();
        } else {
            return ResponseBuilderSale.getResponseNotFound();
        }
    }
}
