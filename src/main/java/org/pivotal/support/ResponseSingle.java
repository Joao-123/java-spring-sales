package org.pivotal.support;

import org.pivotal.models.ResponseData;


/**
 * Class.
 */
public class ResponseSingle extends Response {

    private ResponseData responseData;


    /**
     * @return responseData.
     */
    public ResponseData getResponseData() {
        return responseData;
    }

    /**
     * @param responseData responseData.
     */
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
