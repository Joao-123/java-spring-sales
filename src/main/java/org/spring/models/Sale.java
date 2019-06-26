package org.spring.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class.
 */
public class Sale {
    private String id;
    private String userId;
    private List<String> listProductsIds;
    private String date;


    /**
     * Constructor.
     */
    public Sale() {
        listProductsIds = new ArrayList<>();
    }


    /**
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return user id.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId user id.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return sale date.
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date sale date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return list.
     */
    public List<String> getListProductsIds() {
        return listProductsIds;
    }

    /**
     * @param listProductsIds list.
     */
    public void setListProductsIds(List<String> listProductsIds) {
        this.listProductsIds = listProductsIds;
    }
}
