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
        item.setId(1001);
        item.setName("Coca cola");
        item.setPrice(10.50);
        item.setStock(50);
        Assert.assertEquals(1001, item.getId(), 1);
        Assert.assertEquals("Coca cola", item.getName());
        Assert.assertEquals(10.50, item.getPrice(), 1);
        Assert.assertEquals(50, item.getStock(), 1);
    }
}
