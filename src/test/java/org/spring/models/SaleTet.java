package org.spring.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
        final Integer id = 1001;
        sale.setId(id);
        sale.setIdClient("5897425");
        sale.setIdSeller("9988021");
        // Assert Sale ID
        Assert.assertEquals(id, sale.getId(), 1);
        // Assert User ID
        Assert.assertEquals("5897425", sale.getIdClient());
        // Assert List Products IDs
        Assert.assertEquals("9988021", sale.getIdSeller());
        // Assert Date.
        sale.setDate("26/06/2019");
    }
}
