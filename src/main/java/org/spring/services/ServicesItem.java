package org.spring.services;


import org.spring.models.Item;
import org.spring.responses.Response;
import org.spring.helpers.HelperItem;
import org.spring.services.items.StrategyServiceItemDelete;
import org.spring.services.items.StrategyServiceItemGet;
import org.spring.services.items.StrategyServiceItemGetById;
import org.spring.services.items.StrategyServiceItemPost;
import org.spring.services.items.StrategyServiceItemPut;
import org.springframework.stereotype.Service;

/**
 * Items Services.
 */
@Service
public class ServicesItem {


    private ServicesStrategyManager servicesStrategyManager;

    private StrategyServiceItemGet get;

    private StrategyServiceItemGetById getById;

    private StrategyServiceItemPost post;

    private StrategyServiceItemPut put;

    private StrategyServiceItemDelete delete;

    /**
     * Constructor.
     */
    ServicesItem() {
        servicesStrategyManager = new ServicesStrategyManager();
        get = new StrategyServiceItemGet();
        getById = new StrategyServiceItemGetById();
        post = new StrategyServiceItemPost();
        put = new StrategyServiceItemPut();
        delete = new StrategyServiceItemDelete();
    }

    /**
     * @return Items.
     */
    public Response getAll() {
        return servicesStrategyManager.getResponse(get);
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final Integer id) {
        HelperItem.setId(id);
        return servicesStrategyManager.getResponse(getById);
    }

    /**
     * @param item Item.
     * @return Message.
     */
    public Response add(final Item item) {
        HelperItem.setEntity(item);
        return servicesStrategyManager.getResponse(post);
    }

    /**
     * @param item Item.
     * @param id   Item id.
     * @return Message.
     */
    public Response update(final Item item, final Integer id) {
        HelperItem.setId(id);
        HelperItem.setEntity(item);
        return servicesStrategyManager.getResponse(put);
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final Integer id) {
        HelperItem.setId(id);
        return servicesStrategyManager.getResponse(delete);
    }
}
