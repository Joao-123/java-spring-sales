package org.spring.support;

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
    public static String getSuccessfully(final String entity) {
        return String.format("The get %s successfully", entity);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static String getNotContent(final String entity) {
        return String.format("The %s does not exist", entity);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static String createdSuccessfully(final String entity) {
        return String.format("The %s was created successfully", entity);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static String updatedSuccessfully(final String entity) {
        return String.format("The %s was updated successfully", entity);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static String deletedSuccessfully(final String entity) {
        return String.format("The %s was deleted successfully", entity);
    }

    /**
     * @param entity entity.
     * @return Message.
     */
    public static String entityDoesNotExist(final String entity) {
        return String.format("The %s doesn't exist", entity);
    }
}
