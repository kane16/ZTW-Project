package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The User.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotNull
    private String userName;

    @Column
    private String password;

    @Column
    private UserType userType;

    @Column
    private boolean active;

    @Column
    private String confirmationToken;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roleId")
    private UserRole userRole;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "user")
    private PCConfiguration pcConfiguration;

    /**
     * Gets PCConfiguration.
     *
     * @return the pc configuration
     */
    public PCConfiguration getPcConfiguration() {
        return pcConfiguration;
    }

    /**
     * Sets PCConfiguration.
     *
     * @param pcConfiguration the pc configuration
     */
    public void setPcConfiguration(PCConfiguration pcConfiguration) {
        this.pcConfiguration = pcConfiguration;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets user type.
     *
     * @return the user type
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Sets user type.
     *
     * @param userType the user type
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Checks if is active.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets if is active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets confirmation token.
     *
     * @return the confirmation token
     */
    public String getConfirmationToken() {
        return confirmationToken;
    }

    /**
     * Sets confirmation token.
     *
     * @param confirmationToken the confirmation token
     */
    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * Sets user role.
     *
     * @param userRole the user role
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
