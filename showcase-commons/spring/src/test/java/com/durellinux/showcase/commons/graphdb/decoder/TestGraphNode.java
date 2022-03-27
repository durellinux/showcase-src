package com.durellinux.showcase.commons.graphdb.decoder;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;

public class TestGraphNode extends GraphDbEntity {
    String value;

    public TestGraphNode() {
    }

    public TestGraphNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
