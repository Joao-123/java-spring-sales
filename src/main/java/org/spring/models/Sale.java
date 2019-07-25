package org.spring.models;


import org.spring.support.Magic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Class.
 */
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.SEVEN)
    @Column(name = "id_seller")
    private String idSeller;

    @NotNull
    @Size(min = Magic.SEVEN, max = Magic.SEVEN)
    @Column(name = "id_client")
    private String idClient;

    @NotNull
    @Size(min = Magic.TEN, max = Magic.TEN)
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    @Column(name = "date")
    private String date;

    /**
     * Constructor.
     */
    public Sale() {
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
     * @return getIdClient.
     */
    public String getIdClient() {
        return idClient;
    }

    /**
     * @param idClient idClient.
     */
    public void setIdClient(final String idClient) {
        this.idClient = idClient;
    }
}
