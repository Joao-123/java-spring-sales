package org.pivotal.support;

/**
 * Class.
 */
public final class MessageManager {

    /**
     * Constructor.
     */
    private MessageManager() {
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message getSuccessfully(final String entity) {
        String message = String.format("The get %s  success", entity);
        return new Message("200", message);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message getNotContent(final String entity) {
        String message = String.format("The %s does not exist", entity);
        return new Message("204", message);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message createdSuccessfully(final String entity) {
        String message = String.format("The %s was created", entity);
        return new Message("201", message);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message updatedSuccessfully(final String entity) {
        String message = String.format("The %s was updated", entity);
        return new Message("202", message);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message deletedSuccessfully(final String entity) {
        String message = String.format("The %s was deleted", entity);
        return new Message("200", message);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static Message entityDoesNotExist(final String entity) {
        String message = String.format("The %s doesn't exist", entity);
        return new Message("404", message);
    }
}
