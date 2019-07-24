package org.spring.services.salesitems;

import org.spring.repository.RepositorySaleItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderSaleItem;
import org.spring.services.StrategyService;
import org.spring.services.sales.HelperSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service.
 */
@Service
public class StrategyServiceSaleItemDelete implements StrategyService {

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositorySaleItem.findById(HelperSale.getId()).orElse(null) != null) {
            repositorySaleItem.deleteById(HelperSale.getId());
            return ResponseBuilderSaleItem.getResponseOkForDelete();
        } else {
            return ResponseBuilderSaleItem.getResponseNotFound();
        }
    }
}
