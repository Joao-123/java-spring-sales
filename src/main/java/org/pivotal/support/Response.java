package org.pivotal.support;

/**
 * abstract class.
 */
public abstract class Response {

    private Message message;

    /**
     * @return message.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * @param message message.
     */
    public void setMessage(Message message) {
        this.message = message;
    }

}
