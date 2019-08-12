package org.spring.services.items;

import org.spring.helpers.HelperItem;
import org.spring.models.SaleItem;
import org.spring.repository.RepositoryItem;
import org.spring.repository.RepositorySaleItem;
import org.spring.responses.ResponseBuilderItem;
import org.spring.services.StrategyService;
import org.spring.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyServiceItemDelete implements StrategyService {

    @Autowired
    private RepositoryItem repositoryItem;

    @Autowired
    private RepositorySaleItem repositorySaleItem;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryItem.findById(HelperItem.getId()).orElse(null) != null) {
            List<SaleItem> listSales = this.repositorySaleItem.findItemRelated(HelperItem.getId());
            if (listSales.isEmpty()) {
                repositoryItem.deleteById(HelperItem.getId());
                return ResponseBuilderItem.getResponseOkForDelete();
            }
            return ResponseBuilderItem.getResponseConflictEntityHasRelations();
        }
        return ResponseBuilderItem.getResponseNotFound();

    }
}
