package org.spring.services.Sales;

import org.spring.repository.RepositorySale;
import org.spring.responses.ResponseBuilderSale;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service.
 */
public class StrategyServiceSaleDelete implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositorySale.findById(HelperSale.getId()).orElse(null) != null) {
            repositorySale.deleteById(HelperSale.getId());
            return ResponseBuilderSale.getResponseOkForDelete();
        } else {
            return ResponseBuilderSale.getResponseNotFound();
        }
    }
}
