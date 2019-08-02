package org.spring.models;

import javax.validation.constraints.NotNull;

/**
 * Class.
 */
public class Item {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;

    /**
     * Constructor.
     */
    public Item() {
    }

    /**
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id id.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price price.
     */
    public void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * @return stock.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock stock.
     */
    public void setStock(final Integer stock) {
        this.stock = stock;
    }
}
