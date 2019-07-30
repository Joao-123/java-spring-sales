package org.spring.responses;

import org.spring.models.Item;
import org.spring.models.Sale;
import org.spring.models.User;

/**
 * ResponseManager.
 */
public final class ResponseManager {

    private static ResponseManager responseManager;
    private Response<User> userResponse;
    private Response<Item> itemResponse;
    private Response<Sale> saleResponse;

    /**
     * Constructor.
     */
    private ResponseManager() {
        userResponse = new Response<>();
        itemResponse = new Response<>();
        saleResponse = new Response<>();
    }

    /**
     * @return Singleton.
     */
    private static ResponseManager getSingleton() {
        if (responseManager == null) {
            responseManager = new ResponseManager();
        }
        return responseManager;
    }

    /**
     * @return Response.
     */
    public static Response<User> getResponseUser() {
        return getSingleton().userResponse;
    }

    /**
     * @return Response.
     */
    public static Response<Item> getResponseItem() {
        return getSingleton().itemResponse;
    }

    /**
     * @return Response.
     */
    public static Response<Sale> getResponseSale() {
        return getSingleton().saleResponse;
    }
}
