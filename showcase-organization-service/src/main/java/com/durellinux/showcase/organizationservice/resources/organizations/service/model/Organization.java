package com.durellinux.showcase.organizationservice.resources.organizations.service.model;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.annotations.Node;

import java.util.UUID;

@Node(label = "Organization")
public class Organization extends GraphDbEntity {

    private String name;

    public Organization() {
        // Empty constructor for serialization
    }

    public Organization(String name) {
        this.setName(name);
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // TODO: Validate name
        this.name = name;
    }

}
