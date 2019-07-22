package org.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class.
 */
@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "stock")
    private Integer stock;

    /**
     * Constructor.
     */
    public Item() {
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
    public String getPrice() {
        return price;
    }

    /**
     * @param price price.
     */
    public void setPrice(final String price) {
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
