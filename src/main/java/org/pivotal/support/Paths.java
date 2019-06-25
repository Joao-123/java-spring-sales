package org.pivotal.support;

/**
 * Constants Paths utility class.
 */
public final class Paths {

    private static final String VERSION = "/api/v1";
    private static final String PROJECT = "/projects";
    private static final String USER = "/users";
    private static final String ID = "/{id}";
    public static final String PATH_PROJECTS = VERSION + PROJECT;
    public static final String PATH_PROJECTS_WITH_ID = PATH_PROJECTS + ID;
    public static final String PATH_USERS = VERSION + USER;
    public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;

    /**
     * Private constructor for utility class.
     */
    private Paths() {

    }
}
