package org.spring.services.Sales;

import org.spring.models.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Class
 */
public class HelperSale {

    private static final String ENTITY = "sale";
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
    public static Sale getSale() {
        return getSingleton().sale;
    }

    /**
     * @param sale sale.
     */
    public static void setSale(final Sale sale) {
        getSingleton().sale = sale;
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
