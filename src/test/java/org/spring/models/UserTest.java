package org.spring.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test.
 */
public class UserTest {
    private User user;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        user = new User();
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        user.setId("9652451");
        user.setPassword("secret123");
        user.setName("Harry");
        user.setLastName("Snow");
        user.setBirthDate("1980-20-10");
        user.setEmail("harry.snow@gmail.com");
        user.setType("admin");
        Assert.assertEquals("9652451", user.getId());
        Assert.assertEquals("secret123", user.getPassword());
        Assert.assertEquals("Harry", user.getName());
        Assert.assertEquals("Snow", user.getLastName());
        Assert.assertEquals("1980-20-10", user.getBirthDate());
        Assert.assertEquals("harry.snow@gmail.com", user.getEmail());
        Assert.assertEquals("admin", user.getType());
    }
}
