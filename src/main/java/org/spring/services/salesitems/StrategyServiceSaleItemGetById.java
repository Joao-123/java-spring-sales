package org.spring.services.salesitems;

import org.spring.models.SaleItem;
import org.spring.repository.RepositorySaleItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderSaleItem;
import org.spring.services.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service.
 */
@Service
public class StrategyServiceSaleItemGetById implements StrategyService {

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        SaleItem saleItem = repositorySaleItem.findById(HelperSaleItem.getId()).orElse(null);
        if (saleItem != null) {
            HelperSaleItem.getEmptyList().add(saleItem);
            return ResponseBuilderSaleItem.getResponseOkForGet();
        } else {
            return ResponseBuilderSaleItem.getResponseNotFound();
        }
    }
}
