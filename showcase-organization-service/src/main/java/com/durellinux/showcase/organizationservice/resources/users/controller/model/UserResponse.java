package com.durellinux.showcase.organizationservice.resources.users.controller.model;

import java.util.UUID;

public class UserResponse {
    private final UUID id;
    private final String name;
    private final String surname;

    public UserResponse(UUID id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
