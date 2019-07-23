package org.spring.services.items;

import org.spring.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Project Class.
 */
public final class HelperItem {

    private static final String ENTITY = "item";
    private Integer id;
    private Item item;
    private static HelperItem helperItem;
    private List<Item> itemList;

    /**
     * Constructor.
     */
    private HelperItem() {
        itemList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperItem getSingleton() {
        if (helperItem == null) {
            helperItem = new HelperItem();
        }
        return helperItem;
    }

    /**
     * @return id.
     */
    public static Integer getId() {
        return getSingleton().id;
    }

    /**
     * @param id id.
     */
    public static void setId(final Integer id) {
        getSingleton().id = id;
    }

    /**
     * @return Item.
     */
    public static Item getItem() {
        return getSingleton().item;
    }

    /**
     * @param item item.
     */
    public static void setItem(final Item item) {
        getSingleton().item = item;
    }

    /**
     * @return ENTITY.
     */
    public static String getEntity() {
        return ENTITY;
    }

    /**
     * @return userList.
     */
    public static List<Item> getList() {
        return getSingleton().itemList;
    }

    /**
     * @return userList.
     */
    public static List<Item> getEmptyList() {
        getSingleton().itemList.clear();
        return getSingleton().itemList;
    }
}

