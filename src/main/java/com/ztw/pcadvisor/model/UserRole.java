package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserRole {

    private long roleID;
    private String name;
    private Set<User> users;

    public UserRole(long roleID, String name, Set<User> users) {
        this.roleID = roleID;
        this.name = name;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
