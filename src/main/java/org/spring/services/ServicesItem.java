package org.spring.services;


import org.spring.models.Item;
import org.spring.services.items.*;
import org.spring.support.Response;
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
     * @return Items.
     */
    public Response getAll() {
        return strategyManager.getResponse(strategyGet);
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final Integer id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param item Item.
     * @return Message.
     */
    public Response add(final Item item) {
        HelperItem.setItem(item);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param item Item.
     * @param id   Item id.
     * @return Message.
     */
    public Response update(final Item item, final Integer id) {
        HelperItem.setId(id);
        HelperItem.setItem(item);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final Integer id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
