package org.pivotal.support;

import org.pivotal.models.ResponseData;

import java.util.List;

/**
 * Class.
 */
public class ResponseList extends Response {

    private List<ResponseData> responseData;

    /**
     * @return responseData.
     */
    public List<ResponseData> getResponseData() {
        return responseData;
    }

    /**
     * @param responseData responseData.
     */
    public void setResponseData(final List<ResponseData> responseData) {
        this.responseData = responseData;
    }
}
