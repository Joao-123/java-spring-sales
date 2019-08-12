package org.spring.services;


import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.helpers.HelperItem;
import org.spring.services.items.StrategyServiceItemDelete;
import org.spring.services.items.StrategyServiceItemGet;
import org.spring.services.items.StrategyServiceItemGetById;
import org.spring.services.items.StrategyServiceItemPost;
import org.spring.services.items.StrategyServiceItemPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Items Services.
 */
@Service
public class ServicesItem {


    private StrategyManager strategyManager;

    // Import Strategies
    @Autowired
    private StrategyServiceItemGet strategyGet;

    @Autowired
    private StrategyServiceItemGetById strategyGetById;

    @Autowired
    private StrategyServiceItemPost strategyPost;

    @Autowired
    private StrategyServiceItemPut strategyPut;

    @Autowired
    private StrategyServiceItemDelete strategyDelete;

    /**
     * Constructor.
     */
    ServicesItem() {
        strategyManager = new StrategyManager();
    }

    /**
     * @return Response.
     */
    public Response getAll() {
        return strategyManager.getResponse(strategyGet);
    }

    /**
     * @param id id.
     * @return Response.
     */
    public Response getById(final Integer id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param item item.
     * @return Response.
     */
    public Response add(final Item item) {
        HelperItem.setEntity(item);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param item item.
     * @param id   id.
     * @return Response.
     */
    public Response update(final Item item, final Integer id) {
        HelperItem.setId(id);
        HelperItem.setEntity(item);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id id.
     * @return Response.
     */
    public Response delete(final Integer id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
