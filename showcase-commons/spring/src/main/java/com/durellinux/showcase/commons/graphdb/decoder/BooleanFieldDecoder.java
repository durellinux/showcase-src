package com.durellinux.showcase.commons.graphdb.decoder;

import org.neo4j.driver.types.Node;

import java.util.Set;

public class BooleanFieldDecoder implements IFieldDecoder<Boolean> {
    @Override
    public Set<Class<?>> getDecodedTypes() {
        return Set.of(boolean.class, Boolean.class);
    }

    @Override
    public Boolean decode(String key, Node node) {
        return node.get(key).asBoolean();
    }
}
