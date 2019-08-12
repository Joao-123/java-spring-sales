package org.spring.services.salesitems;

import org.spring.helpers.HelperSaleItem;
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
public class StrategyServiceSaleItemPut implements StrategyService {

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositorySaleItem.findById(HelperSaleItem.getId()).orElse(null) != null) {
            HelperSaleItem.getEntity().setId(HelperSaleItem.getId());
            repositorySaleItem.save(HelperSaleItem.getEntity());
            HelperSaleItem.getEmptyList().add(HelperSaleItem.getEntity());
            return ResponseBuilderSaleItem.getResponseOkForPut();
        } else {
            return ResponseBuilderSaleItem.getResponseNotFound();
        }
    }
}
