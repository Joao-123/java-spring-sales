package org.spring.services.users;

import org.spring.services.StrategyResponse;
import org.spring.support.MessageManager;
import org.spring.support.Response;
import org.springframework.http.HttpStatus;

/**
 * Class.
 */
public class UserGet implements StrategyResponse {

    /**
     * Constructor.
     */
    public UserGet() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        HelperUserList
                .getResponse()
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(MessageManager.getSuccessfully(HelperUser.getEntity()))
                .setData(HelperUserList.getList());
        return HelperUserList.getResponse();
    }
}
