package org.spring.services.items;

import org.spring.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Helper Class.
 */
public final class HelperItemList {

    private static final String ENTITY = "project";
    private static HelperItemList helperItemList;
    private List<Item> itemList;

    /**
     * Constructor.
     */
    private HelperItemList() {
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
     * @return ENTITY.
     */
    public static String getEntity() {
        return ENTITY;
    }

}
