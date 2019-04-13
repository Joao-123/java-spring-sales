package org.spring.support;

/**
 * Constants Paths utility class.
 */
public final class Paths {

    private static final String VERSION = "/api/v1";
    private static final String USER = "/users";
    private static final String ITEM = "/items";
    private static final String ID = "/{id}";
    public static final String PATH_USERS = VERSION + USER;
    public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
    public static final String PATH_ITEMS = VERSION + ITEM;
    public static final String PATH_ITEMS_WITH_ID = PATH_ITEMS + ID;

    /**
     * Private constructor for utility class.
     */
    private Paths() {

    }
}
