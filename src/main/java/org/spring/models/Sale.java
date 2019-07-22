package org.spring.models;

import java.util.List;

/**
 * Class.
 */
public class Sale {
    private String id;
    private String sellerId;
    private String clientId;
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
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId user id.
     */
    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
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

    /**
     * @return getClientId.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId clientId.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
