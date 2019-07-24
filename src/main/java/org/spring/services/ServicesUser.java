package org.spring.services;

import org.spring.models.User;
import org.spring.responses.Response;
import org.spring.services.users.HelperUser;
import org.spring.services.users.StrategyServiceUserDelete;
import org.spring.services.users.StrategyServiceUserGet;
import org.spring.services.users.StrategyServiceUserGetById;
import org.spring.services.users.StrategyServiceUserPost;
import org.spring.services.users.StrategyServiceUserPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Users Services.
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
     * @return Response.
     */
    public Response getAll() {
        return strategyManager.getResponse(strategyGet);
    }

    /**
     * @param id id.
     * @return Response.
     */
    public Response getById(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param user user.
     * @return Response.
     */
    public Response add(final User user) {
        HelperUser.setEntity(user);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param user user.
     * @param id   id.
     * @return Response.
     */
    public Response update(final User user, final String id) {
        HelperUser.setId(id);
        HelperUser.setEntity(user);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id id.
     * @return Response.
     */
    public Response delete(final String id) {
        HelperUser.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
