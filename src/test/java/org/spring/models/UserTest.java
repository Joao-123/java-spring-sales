package org.spring.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Test.
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
        user.setBirthDate("20/10/1980");
        user.setEmail("harry.snow@gmail.com");
        user.setType("admin");
        assertEquals("9652451", user.getId());
        assertEquals("secret123", user.getPassword());
        assertEquals("Harry", user.getName());
        assertEquals("Snow", user.getLastName());
        assertEquals("20/10/1980", user.getBirthDate());
        assertEquals("harry.snow@gmail.com", user.getEmail());
        assertEquals("admin", user.getType());
    }
}
