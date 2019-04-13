package org.spring.services;

import org.spring.models.User;
import org.spring.services.users.HelperUser;
import org.spring.services.users.UserDelete;
import org.spring.services.users.UserGet;
import org.spring.services.users.UserGetById;
import org.spring.services.users.UserPost;
import org.spring.services.users.UserPut;
import org.spring.support.Response;
import org.springframework.stereotype.Service;

/**
 * User Services.
 */
@Service
public class ServicesUser {

    private StrategyManager strategyManager;

    /**
     * Constructor.
     */
    ServicesUser() {
        strategyManager = new StrategyManager();
    }

    /**
     * @return modelProjectList.
     */
    public Response getAll() {
        return strategyManager.getResponse(new UserGet());
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(new UserGetById());
    }

    /**
     * @param user user.
     * @return Message.
     */
    public Response add(final User user) {
        HelperUser.setUser(user);
        return strategyManager.getResponse(new UserPost());
    }

    /**
     * @param user user.
     * @param id   id.
     * @return Message.
     */
    public Response update(final User user, final String id) {
        HelperUser.setId(id);
        HelperUser.setUser(user);
        return strategyManager.getResponse(new UserPut());
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(new UserDelete());
    }
}
