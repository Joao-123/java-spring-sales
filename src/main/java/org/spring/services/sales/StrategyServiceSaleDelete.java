package org.spring.services.sales;

import org.spring.helpers.HelperSale;
import org.spring.models.SaleItem;
import org.spring.repository.RepositorySale;
import org.spring.repository.RepositorySaleItem;
import org.spring.responses.ResponseBuilderSale;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyServiceSaleDelete implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositorySale.findById(HelperSale.getId()).orElse(null) != null) {
            List<SaleItem> listSales = this.repositorySaleItem.findSaleRelated(HelperSale.getId());
            if (listSales.isEmpty()) {
                repositorySale.deleteById(HelperSale.getId());
                return ResponseBuilderSale.getResponseOkForDelete();
            }
            return ResponseBuilderSale.getResponseConflictEntityHasRelations();
        }
        return ResponseBuilderSale.getResponseNotFound();
    }
}
