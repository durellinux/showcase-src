package com.durellinux.showcase.commons.graphdb.decoder;

import org.neo4j.driver.types.Node;

import java.util.Set;

public interface IFieldDecoder<T> {
    Set<Class<?>> getDecodedTypes();
    T decode(String key, Node node);
}
