package org.spring.services.items;

import org.spring.models.Item;
import org.spring.support.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Helper Class.
 */
public final class HelperItemList {

    private static final String ENTITY = "project";
    private static HelperItemList helperItemList;
    private List<Item> itemList;
    private Response<Item> response;

    /**
     * Constructor.
     */
    private HelperItemList() {
        response = new Response<>();
        itemList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperItemList getSingleton() {
        if (helperItemList == null) {
            helperItemList = new HelperItemList();
        }
        return helperItemList;
    }

    /**
     * @return itemList.
     */
    public static List<Item> getModelProjectList() {
        return getSingleton().itemList;
    }

    /**
     * @return response.
     */
    public static Response<Item> getResponse() {
        return getSingleton().response;
    }

    /**
     * @return ENTITY.
     */
    public static String getEntity() {
        return ENTITY;
    }

}
