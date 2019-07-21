package org.spring.services.users;

import org.spring.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Helper.
 */
public final class HelperUserList {

    private static HelperUserList helperUserList;
    private List<User> userList;

    /**
     * Constructor.
     */
    private HelperUserList() {
        userList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperUserList getSingleton() {
        if (helperUserList == null) {
            helperUserList = new HelperUserList();
        }
        return helperUserList;
    }

    /**
     * @return userList.
     */
    public static List<User> getList() {
        return getSingleton().userList;
    }

}
