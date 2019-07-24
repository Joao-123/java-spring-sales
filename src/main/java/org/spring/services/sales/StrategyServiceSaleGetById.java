package org.spring.services.sales;

import org.spring.models.Sale;
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
public class StrategyServiceSaleGetById implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Sale sale = repositorySale.findById(HelperSale.getId()).orElse(null);
        if (sale != null) {
            HelperSale.getEmptyList().add(sale);
            return ResponseBuilderSale.getResponseOkForGet();
        } else {
            return ResponseBuilderSale.getResponseNotFound();
        }
    }
}
