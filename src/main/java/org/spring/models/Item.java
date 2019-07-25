package org.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class.
 */
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
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
