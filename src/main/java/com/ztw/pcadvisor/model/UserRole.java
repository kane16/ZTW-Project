package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The User role.
 */
@Entity
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "userRole")
    private Set<User> users = new HashSet<>();

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
