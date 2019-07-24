package org.spring.services.Sales;

import org.spring.repository.RepositorySale;
import org.spring.responses.ResponseBuilderSale;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service.
 */
@Service
public class StrategyServiceSalePut implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositorySale.findById(HelperSale.getId()).orElse(null) != null) {
            HelperSale.getSale().setId(HelperSale.getId());
            repositorySale.save(HelperSale.getSale());
            HelperSale.getEmptyList().add(HelperSale.getSale());
            return ResponseBuilderSale.getResponseOkForPut();
        } else {
            return ResponseBuilderSale.getResponseNotFound();
        }
    }
}
