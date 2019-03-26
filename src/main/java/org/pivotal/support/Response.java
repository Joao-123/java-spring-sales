package org.pivotal.support;

import org.springframework.http.HttpStatus;

/**
 * abstract class.
 * Generic Builder.
 */
public class Response<T> {

    private HttpStatus httpStatus;
    private ResponseBody<T> body;

    /**
     * Constructor.
     */
    public Response() {
        body = new ResponseBody<>();
    }

    /**
     * @return httpStatus.
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus httpStatus.
     */
    public Response<T> setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }


    /**
     * @return body.
     */
    public ResponseBody<T> getBody() {
        return body;
    }

    /**
     * @param body body.
     */
    public Response<T> setBody(ResponseBody<T> body) {
        this.body = body;
        return this;
    }
}
