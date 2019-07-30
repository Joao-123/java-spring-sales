package org.spring.services.items;

import org.spring.models.Item;

/**
 * Helper Project Class.
 */
public final class HelperItem {

    private static final String ENTITY_NAME = "item";
    private String id;
    private Item entity;
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
    public static Item getEntity() {
        return getSingleton().entity;
    }

    /**
     * @param item item.
     */
    public static void setEntity(final Item item) {
        getSingleton().entity = item;
    }

    /**
     * @return Entity Name.
     */
    public static String getEntityName() {
        return ENTITY_NAME;
    }
}
