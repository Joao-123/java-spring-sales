package org.spring.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test.
 */
public class ItemTest {

    private Item item;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        item = new Item();
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        final Integer id = 1001;
        item.setId(id);
        item.setName("Coca cola");
        final Double price = 10.0;
        item.setPrice(price);
        Assert.assertEquals(id, item.getId(), 1);
        Assert.assertEquals("Coca cola", item.getName());
        Assert.assertEquals(price, item.getPrice(), 1);
    }
}
