package com.durellinux.showcase.organizationservice.resources.users.service.model;


import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.annotations.Node;

@Node(label = "User")
public class User extends GraphDbEntity {
    private String name;
    private String surname;
    private String email;

    protected User() {
        // Empty constructor for serialization
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void verifyEmail(String newEmail) {
        this.email = newEmail;
    }
}
