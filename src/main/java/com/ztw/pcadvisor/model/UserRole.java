package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "userRole")
    private Set<User> users = new HashSet<>();

}
