package org.spring.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Test.
 */
public class SaleTet {

    private Sale sale;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        sale = new Sale();
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        // Create User
        sale.setId(1001);
        sale.setIdClient("5897425");
        sale.setIdSeller("9988021");
        // Assert Sale ID
        Assert.assertEquals(1001, sale.getId(), 1);
        // Assert User ID
        Assert.assertEquals("5897425", sale.getIdClient());
        // Assert List Products IDs
        Assert.assertEquals("9988021", sale.getIdSeller());
        // Assert Date.
        sale.setDate("26/06/2019");
    }
}
