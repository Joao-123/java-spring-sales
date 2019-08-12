package org.spring.services.salesitems;

import org.spring.helpers.HelperSaleItem;
import org.spring.models.Item;
import org.spring.models.Sale;
import org.spring.repository.RepositoryItem;
import org.spring.repository.RepositorySale;
import org.spring.repository.RepositorySaleItem;
import org.spring.responses.Response;
import org.spring.responses.ResponseBuilderSaleItem;
import org.spring.services.StrategyService;
import org.spring.helpers.HelperSale;
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

    @Autowired
    private RepositoryItem repositoryItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperSale.getEmptyList().add(HelperSale.getEntity());
        Sale sale = repositorySale.findById(HelperSaleItem.getEntity().getIdSale()).orElse(null);
        Item item = repositoryItem.findById(HelperSaleItem.getEntity().getIdItem()).orElse(null);
        if (sale != null && item != null) {
            repositorySaleItem.save(HelperSaleItem.getEntity());
            return ResponseBuilderSaleItem.getResponseOkForPost();
        } else {
            return ResponseBuilderSaleItem.getResponseNotFound();
        }
    }
}
