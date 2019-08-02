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
        sale.setId("1000001");
        sale.setIdSeller("5897425");
        sale.setIdClient("5897425");
        final List<Integer> listProductIds = new ArrayList<>();
        listProductIds.add(1000001);
        listProductIds.add(1002);
        listProductIds.add(1004);
        listProductIds.add(1005);
        sale.setListItemsIds(listProductIds);
        // Assert Sale ID
        Assert.assertEquals("1000001", sale.getId());
        // Assert User ID
        Assert.assertEquals("5897425", sale.getIdSeller());
        // Assert List Products IDs
        Assert.assertArrayEquals(listProductIds.toArray(), sale.getListItemsIds().toArray());
        // Assert Date.
        sale.setDate("2019-06-26");
    }
}
