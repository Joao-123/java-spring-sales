package org.spring.models;

/**
 * Class.
 */
public class User {
    private String id;
    private String password;
    private String name;
    private String lastName;
    private String birthDate;
    private String email;
    private String type;

    /**
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName setLastName.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }


    /**
     * @return birthDate.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate setBirthDate.
     */
    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type.
     */
    public void setType(final String type) {
        this.type = type;
    }

}
