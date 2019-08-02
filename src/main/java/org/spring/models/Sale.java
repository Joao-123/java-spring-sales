package org.spring.models;

import org.spring.support.Magic;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Class.
 */
public class Sale {

    private String id;

    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.SEVEN)
    private String idSeller;

    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.SEVEN)
    private String idClient;

    @NotNull
    @Size(min = Magic.TEN, max = Magic.TEN)
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    private String date;

    @NotNull
    private List<Integer> listItemsIds;

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
    public String getIdSeller() {
        return idSeller;
    }

    /**
     * @param idSeller user id.
     */
    public void setIdSeller(final String idSeller) {
        this.idSeller = idSeller;
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
    public List<Integer> getListItemsIds() {
        return listItemsIds;
    }

    /**
     * @param listItemsIds list.
     */
    public void setListItemsIds(final List<Integer> listItemsIds) {
        this.listItemsIds = listItemsIds;
    }

    /**
     * @return idClient.
     */
    public String getIdClient() {
        return idClient;
    }

    /**
     * @param idClient idClient.
     */
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
