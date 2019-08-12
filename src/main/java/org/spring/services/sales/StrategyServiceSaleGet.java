package org.spring.services.sales;

import org.spring.helpers.HelperSale;
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
public class StrategyServiceSaleGet implements StrategyService {

    @Autowired
    private RepositorySale repositorySale;

    /**
     * Constructor.
     */
    public StrategyServiceSaleGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Iterable<Sale> iterable = this.repositorySale.findAll();
        HelperSale.getEmptyList();
        iterable.forEach(HelperSale.getList()::add);
        return ResponseBuilderSale.getResponseOkForGet();
    }
}
