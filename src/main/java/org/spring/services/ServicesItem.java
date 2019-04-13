package org.spring.services;


import org.spring.models.Item;
import org.spring.services.items.HelperItem;
import org.spring.services.items.ItemDelete;
import org.spring.services.items.ItemGet;
import org.spring.services.items.ItemGetById;
import org.spring.services.items.ItemPost;
import org.spring.services.items.ItemPut;
import org.spring.support.Response;
import org.springframework.stereotype.Service;

/**
 * Items Services.
 */
@Service
public class ServicesItem {


    private StrategyManager strategyManager;

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
        return strategyManager.getResponse(new ItemGet());
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final String id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(new ItemGetById());
    }

    /**
     * @param item Item.
     * @return Message.
     */
    public Response add(final Item item) {
        HelperItem.setModelProject(item);
        return strategyManager.getResponse(new ItemPost());
    }

    /**
     * @param item Item.
     * @param id   Item id.
     * @return Message.
     */
    public Response update(final Item item, final String id) {
        HelperItem.setId(id);
        HelperItem.setModelProject(item);
        return strategyManager.getResponse(new ItemPut());
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final String id) {
        HelperItem.setId(id);
        return strategyManager.getResponse(new ItemDelete());
    }
}
