package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    private long userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Set<UserRole> roles;
    private int active;

    public User(long userID, String firstName, String lastName, String userName, String password, Set<UserRole> roles, int active) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }

    public int getActive() {
        return active;
    }

    @Column(nullable = false)
    public void setActive(int active) {
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name = "user_with_role", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }


}
