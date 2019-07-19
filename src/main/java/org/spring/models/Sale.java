package org.spring.models;

import java.util.List;

/**
 * Class.
 */
public class Sale {
    private String id;
    private String userId;
    private List<String> listItemsIds;
    private String date;

    /**
     * Constructor.
     */
    public Sale() {
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
    public void setId(final String id) {
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
    public void setUserId(final String userId) {
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
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @return list.
     */
    public List<String> getListItemsIds() {
        return listItemsIds;
    }

    /**
     * @param listItemsIds list.
     */
    public void setListItemsIds(final List<String> listItemsIds) {
        this.listItemsIds = listItemsIds;
    }
}
