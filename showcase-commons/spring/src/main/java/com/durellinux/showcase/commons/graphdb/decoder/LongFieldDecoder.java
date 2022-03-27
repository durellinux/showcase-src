package com.durellinux.showcase.commons.graphdb.decoder;

import org.neo4j.driver.types.Node;

import java.util.Set;

public class LongFieldDecoder implements IFieldDecoder<Long> {
    @Override
    public Set<Class<?>> getDecodedTypes() {
        return Set.of(Long.class, long.class);
    }

    @Override
    public Long decode(String key, Node node) {
        return node.get(key).asLong();
    }
}
