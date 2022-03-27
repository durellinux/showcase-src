package com.durellinux.showcase.commons.graphdb;

import com.durellinux.showcase.commons.graphdb.annotations.NodeId;

import java.util.UUID;

public abstract class GraphDbEntity {
    @NodeId
    protected Long id;
    protected String uuid = UUID.randomUUID().toString();
    protected boolean deleted = false;

    protected GraphDbEntity() {
        this.deleted = false;
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Long getId() {
        return id;
    }
}
