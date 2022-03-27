package com.durellinux.showcase.organizationservice.commons.neo4j;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.GraphDbRelation;
import com.durellinux.showcase.commons.graphdb.annotations.Node;
import com.durellinux.showcase.commons.graphdb.annotations.Relation;

import java.util.HashMap;
import java.util.Map;

public class Neo4jLabelProvider {
    private static Neo4jLabelProvider instance;
    private final Map<Class, String> labelMap;

    private Neo4jLabelProvider() {
        labelMap = new HashMap<>();
    }

    public static Neo4jLabelProvider getInstance() {
        if (instance == null) {
            instance = new Neo4jLabelProvider();
        }

        return instance;
    }

    public <T extends GraphDbEntity> String getNodeLabel(Class<T> clazz) {
        if (labelMap.containsKey(clazz)) {
            return labelMap.get(clazz);
        }

        Node nodeAnnotation = clazz.getAnnotation(Node.class);
        String label = nodeAnnotation.label();
        labelMap.put(clazz, label);
        return label;
    }

    public <T extends GraphDbRelation> String getRelationLabel(Class<T> clazz) {
        if (labelMap.containsKey(clazz)) {
            return labelMap.get(clazz);
        }

        Relation relation = clazz.getAnnotation(Relation.class);
        String label = relation.type();
        labelMap.put(clazz, label);
        return label;
    }

}
