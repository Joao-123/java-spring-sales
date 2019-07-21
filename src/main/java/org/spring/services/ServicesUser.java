package org.spring.services;

import org.spring.models.User;
import org.spring.services.users.HelperUser;
import org.spring.services.users.StrategyServiceUserDelete;
import org.spring.services.users.StrategyServiceUserGet;
import org.spring.services.users.StrategyServiceUserGetById;
import org.spring.services.users.StrategyServiceUserPost;
import org.spring.services.users.StrategyServiceUserPut;
import org.spring.support.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Services.
 */
@Service
public class ServicesUser {

    private StrategyManager strategyManager;

    // Import Strategies
    @Autowired
    private StrategyServiceUserGet strategyGet;

    @Autowired
    private StrategyServiceUserGetById strategyGetById;

    @Autowired
    private StrategyServiceUserPost strategyPost;

    @Autowired
    private StrategyServiceUserPut strategyPut;

    @Autowired
    private StrategyServiceUserDelete strategyDelete;

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
        return strategyManager.getResponse(strategyGet);
    }

    /**
     * @param id Item id.
     * @return Item.
     */
    public Response getById(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param user user.
     * @return Message.
     */
    public Response add(final User user) {
        HelperUser.setUser(user);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param user user.
     * @param id   id.
     * @return Message.
     */
    public Response update(final User user, final String id) {
        HelperUser.setId(id);
        HelperUser.setUser(user);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id Item id.
     * @return Message.
     */
    public Response delete(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
