package org.spring.services;

import org.spring.models.User;
import org.spring.helpers.HelperUser;
import org.spring.responses.Response;
import org.spring.services.users.StrategyServiceUserDelete;
import org.spring.services.users.StrategyServiceUserGet;
import org.spring.services.users.StrategyServiceUserGetById;
import org.spring.services.users.StrategyServiceUserPost;
import org.spring.services.users.StrategyServiceUserPut;
import org.springframework.stereotype.Service;

/**
 * User Services.
 */
@Service
public class ServicesUser {

    private ServicesStrategyManager strategyManager;

    private StrategyServiceUserGet get;

    private StrategyServiceUserGetById getById;

    private StrategyServiceUserPost post;

    private StrategyServiceUserPut put;

    private StrategyServiceUserDelete delete;

    /**
     * Constructor.
     */
    ServicesUser() {
        strategyManager = new ServicesStrategyManager();
    }

    /**
     * @return modelProjectList.
     */
    public Response getAll() {
        return strategyManager.getResponse(get);
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(getById);
    }

    /**
     * @param user user.
     * @return Message.
     */
    public Response add(final User user) {
        HelperUser.setEntity(user);
        return strategyManager.getResponse(post);
    }

    /**
     * @param user user.
     * @param id   id.
     * @return Message.
     */
    public Response update(final User user, final String id) {
        HelperUser.setId(id);
        HelperUser.setEntity(user);
        return strategyManager.getResponse(put);
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(delete);
    }
}
