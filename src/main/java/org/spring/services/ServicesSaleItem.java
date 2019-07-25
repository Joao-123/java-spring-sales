package org.spring.services;

import org.spring.models.SaleItem;
import org.spring.responses.Response;
import org.spring.services.salesitems.HelperSaleItem;
import org.spring.services.salesitems.StrategyServiceSaleItemDelete;
import org.spring.services.salesitems.StrategyServiceSaleItemGet;
import org.spring.services.salesitems.StrategyServiceSaleItemGetById;
import org.spring.services.salesitems.StrategyServiceSaleItemPost;
import org.spring.services.salesitems.StrategyServiceSaleItemPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service.
 */
@Service
public class ServicesSaleItem {

    private StrategyManager strategyManager;

    // Import Strategies
    @Autowired
    private StrategyServiceSaleItemGet strategyGet;

    @Autowired
    private StrategyServiceSaleItemGetById strategyGetById;

    @Autowired
    private StrategyServiceSaleItemPost strategyPost;

    @Autowired
    private StrategyServiceSaleItemPut strategyPut;

    @Autowired
    private StrategyServiceSaleItemDelete strategyDelete;

    /**
     * Constructor.
     */
    ServicesSaleItem() {
        strategyManager = new StrategyManager();
    }

    /**
     * @return response.
     */
    public Response getAll() {
        return strategyManager.getResponse(strategyGet);
    }

    /**
     * @param id Item id.
     * @return response.
     */
    public Response getById(final Integer id) {
        HelperSaleItem.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param saleItem saleItem.
     * @return response.
     */
    public Response add(final SaleItem saleItem) {
        HelperSaleItem.setEntity(saleItem);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param saleItem saleItem.
     * @param id       id.
     * @return response.
     */
    public Response update(final SaleItem saleItem, final Integer id) {
        HelperSaleItem.setId(id);
        HelperSaleItem.setEntity(saleItem);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id id.
     * @return response.
     */
    public Response delete(final Integer id) {
        HelperSaleItem.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
