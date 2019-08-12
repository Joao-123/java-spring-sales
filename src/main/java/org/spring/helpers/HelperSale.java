package org.spring.helpers;

import org.spring.models.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Class.
 */
public final class HelperSale {

    private static final String ENTITY_NAME = "sale";
    private Integer id;
    private Sale sale;
    private static HelperSale helperSale;
    private List<Sale> saleList;

    /**
     * Constructor.
     */
    private HelperSale() {
        saleList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperSale getSingleton() {
        if (helperSale == null) {
            helperSale = new HelperSale();
        }
        return helperSale;
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
    public static Sale getEntity() {
        return getSingleton().sale;
    }

    /**
     * @param sale sale.
     */
    public static void setEntity(final Sale sale) {
        getSingleton().sale = sale;
    }

    /**
     * @return ENTITY_NAME.
     */
    public static String getEntityName() {
        return ENTITY_NAME;
    }

    /**
     * @return userList.
     */
    public static List<Sale> getList() {
        return getSingleton().saleList;
    }

    /**
     * @return userList.
     */
    public static List<Sale> getEmptyList() {
        getSingleton().saleList.clear();
        return getSingleton().saleList;
    }
}
