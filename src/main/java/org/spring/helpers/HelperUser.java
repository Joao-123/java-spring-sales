package org.spring.helpers;

import org.spring.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper Class.
 */
public final class HelperUser {

    private static final String ENTITY_NAME = "user";
    private static HelperUser helperUser;
    private String id;
    private User user;
    private List<User> userList;

    /**
     * Constructor.
     */
    private HelperUser() {
        userList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperUser getSingleton() {
        if (helperUser == null) {
            helperUser = new HelperUser();
        }
        return helperUser;
    }

    /**
     * @return id.
     */
    public static String getId() {
        return getSingleton().id;
    }

    /**
     * @param id id.
     */
    public static void setId(final String id) {
        getSingleton().id = id;
    }

    /**
     * @return user.
     */
    public static User getEntity() {
        return getSingleton().user;
    }

    /**
     * @param user user.
     */
    public static void setEntity(final User user) {
        getSingleton().user = user;
    }

    /**
     * @return ENTITY_NAME.
     */
    public static String getEntityName() {
        return ENTITY_NAME;
    }

    /**
     * @return userList.
     */
    public static List<User> getList() {
        return getSingleton().userList;
    }

    /**
     * @return userList.
     */
    public static List<User> getEmptyList() {
        getSingleton().userList.clear();
        return getSingleton().userList;
    }
}
