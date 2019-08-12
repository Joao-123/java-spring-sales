package org.spring.services;

import org.spring.models.Sale;
import org.spring.responses.Response;
import org.spring.helpers.HelperSale;
import org.spring.services.sales.StrategyServiceSaleDelete;
import org.spring.services.sales.StrategyServiceSaleGet;
import org.spring.services.sales.StrategyServiceSaleGetById;
import org.spring.services.sales.StrategyServiceSalePost;
import org.spring.services.sales.StrategyServiceSalePut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sales Service.
 */
@Service
public class ServicesSale {

    private StrategyManager strategyManager;

    // Import Strategies
    @Autowired
    private StrategyServiceSaleGet strategyGet;

    @Autowired
    private StrategyServiceSaleGetById strategyGetById;

    @Autowired
    private StrategyServiceSalePost strategyPost;

    @Autowired
    private StrategyServiceSalePut strategyPut;

    @Autowired
    private StrategyServiceSaleDelete strategyDelete;

    /**
     * Constructor.
     */
    ServicesSale() {
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
        HelperSale.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param sale sale.
     * @return response.
     */
    public Response add(final Sale sale) {
        HelperSale.setEntity(sale);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param sale sale.
     * @param id   id.
     * @return response.
     */
    public Response update(final Sale sale, final Integer id) {
        HelperSale.setId(id);
        HelperSale.setEntity(sale);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id id.
     * @return response.
     */
    public Response delete(final Integer id) {
        HelperSale.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
