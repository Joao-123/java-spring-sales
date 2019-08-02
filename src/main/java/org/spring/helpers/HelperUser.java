package org.spring.helpers;

import org.spring.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Helper.
 */
public final class HelperUser {

    private static final String ENTITY_NAME = "entity";
    private static HelperUser helperUser;
    private String id;
    private User entity;
    private List<User> userList;
    private List<User> userListHelper;

    /**
     * Constructor.
     */
    private HelperUser() {
        userList = new ArrayList<>();
        userListHelper = new ArrayList<>();
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
     * @return entity.
     */
    public static User getEntity() {
        return getSingleton().entity;
    }

    /**
     * @param user entity.
     */
    public static void setEntity(final User user) {
        getSingleton().entity = user;
    }

    /**
     * @return ENTITY.
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
    public static List<User> getListHelper() {
        return getSingleton().userListHelper;
    }

    /**
     * @return userList.
     */
    public static List<User> getEmptyListHelper() {
        getSingleton().userListHelper.clear();
        return getSingleton().userListHelper;
    }
}
