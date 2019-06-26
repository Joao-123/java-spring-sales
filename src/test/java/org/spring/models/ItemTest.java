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
        item.setId("1001");
        item.setName("Coca cola");
        item.setPrice("10");
        Assert.assertEquals("1001", item.getId());
        Assert.assertEquals("Coca cola", item.getName());
        Assert.assertEquals("10", item.getPrice());
    }
}
