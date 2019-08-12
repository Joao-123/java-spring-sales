package org.spring.helpers;

import org.spring.models.SaleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Class.
 */
public final class HelperSaleItem {

    private static final String ENTITY_NAME = "saleItem";
    private static HelperSaleItem helperSaleItem;
    private Integer id;
    private SaleItem saleItem;
    private List<SaleItem> saleItemList;

    /**
     * Constructor.
     */
    private HelperSaleItem() {
        saleItemList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperSaleItem getSingleton() {
        if (helperSaleItem == null) {
            helperSaleItem = new HelperSaleItem();
        }
        return helperSaleItem;
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
     * @return user.
     */
    public static SaleItem getEntity() {
        return getSingleton().saleItem;
    }

    /**
     * @param saleItem saleItem.
     */
    public static void setEntity(final SaleItem saleItem) {
        getSingleton().saleItem = saleItem;
    }

    /**
     * @return ENTITY_NAME.
     */
    public static String getEntityName() {
        return ENTITY_NAME;
    }

    /**
     * @return saleItemList.
     */
    public static List<SaleItem> getList() {
        return getSingleton().saleItemList;
    }

    /**
     * @return saleItemList.
     */
    public static List<SaleItem> getEmptyList() {
        getSingleton().saleItemList.clear();
        return getSingleton().saleItemList;
    }
}
