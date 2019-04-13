package org.spring.services.items;

import org.spring.models.Item;

/**
 * Helper Project Class.
 */
public final class HelperItem {

    private String id;
    private Item item;
    private static HelperItem helperItem;

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
    public static String getId() {
        return getSingleton().id;
    }

    /**
     * @param id id.
     */
    public static void setId(final String id) {
        getSingleton().id = id;
    }

    /**
     * @return Item.
     */
    public static Item getModelProject() {
        return getSingleton().item;
    }

    /**
     * @param item item.
     */
    public static void setModelProject(final Item item) {
        getSingleton().item = item;
    }
}
