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
public class StrategyServiceSaleItemGet implements StrategyService {

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * Constructor.
     */
    public StrategyServiceSaleItemGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Iterable<SaleItem> iterable = this.repositorySaleItem.findAll();
        HelperSaleItem.getEmptyList();
        iterable.forEach(HelperSaleItem.getList()::add);
        return ResponseBuilderSaleItem.getResponseOkForGet();
    }
}
