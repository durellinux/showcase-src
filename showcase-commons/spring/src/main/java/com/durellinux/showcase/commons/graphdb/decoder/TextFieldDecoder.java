package com.durellinux.showcase.commons.graphdb.decoder;

import org.neo4j.driver.types.Node;

import java.util.Set;

public class TextFieldDecoder implements IFieldDecoder<String> {
    @Override
    public Set<Class<?>> getDecodedTypes() {
        return Set.of(String.class);
    }

    @Override
    public String decode(String key, Node node) {
        return node.get(key).asString();
    }
}
