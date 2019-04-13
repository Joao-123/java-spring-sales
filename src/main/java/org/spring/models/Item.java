package org.spring.models;

/**
 * Class.
 */
public class Item {

    private String id;

    private String name;

    private String price;

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
}
