package org.pivotal.support;

import java.time.Instant;

/**
 * Class.
 */
public class Message {

    private String code;
    private String textMessage;
    private long unixTimestamp;

    /**
     * Constructor.
     */
    public Message() {
    }

    /**
     * @param code        code.
     * @param textMessage textMessage.
     */
    Message(final String code, final String textMessage) {
        this.code = code;
        this.textMessage = textMessage;
        this.unixTimestamp = Instant.now().getEpochSecond();
    }

    /**
     * @param code code.
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * @param textMessage textMessage.
     */
    public void setTextMessage(final String textMessage) {
        this.textMessage = textMessage;
    }

    /**
     * @return unixTimestamp.
     */
    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    /**
     * @param unixTimestamp setUnixTimestamp.
     */
    public void setUnixTimestamp(final long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    /**
     * @return textMessage.
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * @return code.
     */
    public String getCode() {
        return code;
    }
}
