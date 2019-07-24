package org.spring.services.salesitems;

import org.spring.models.Sale;
import org.spring.repository.RepositorySale;
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
public class StrategyServiceSaleItemPost implements StrategyService {

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    @Autowired
    private RepositorySale repositorySale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperSale.getEmptyList().add(HelperSale.getEntity());
        Sale sale = repositorySale.findById(HelperSaleItem.getEntity().getIdSale()).orElse(null);
        if (sale != null) {
            repositorySaleItem.save(HelperSaleItem.getEntity());
            return ResponseBuilderSaleItem.getResponseOkForPost();
        } else {
            return ResponseBuilderSaleItem.getResponseNotFound();
        }
    }
}
