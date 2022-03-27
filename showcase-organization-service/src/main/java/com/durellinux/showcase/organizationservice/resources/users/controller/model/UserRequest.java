package com.durellinux.showcase.organizationservice.resources.users.controller.model;

import javax.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    public String getName() { return name; }

    public String getSurname() { return name; }

    public String getEmail() {
        return email;
    }
}
