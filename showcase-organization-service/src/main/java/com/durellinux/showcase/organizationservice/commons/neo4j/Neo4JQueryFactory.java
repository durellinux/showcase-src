package com.durellinux.showcase.organizationservice.commons.neo4j;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.GraphDbRelation;
import com.durellinux.showcase.commons.graphdb.annotations.Node;
import com.durellinux.showcase.commons.graphdb.annotations.NodeId;
import com.durellinux.showcase.commons.graphdb.annotations.Relation;
import com.durellinux.showcase.commons.graphdb.annotations.RelationField;
import org.neo4j.driver.Query;
import org.neo4j.driver.Value;
import org.reflections.ReflectionUtils;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static org.neo4j.driver.Values.value;

public class Neo4JQueryFactory {
    private final Map<Class, List<Field>> serializableFieldsMap;

    public Neo4JQueryFactory() {
        serializableFieldsMap = new HashMap<>();
    }

    public <T extends GraphDbEntity> Query createQuery(T entity, String nodeName) {
        return new Query(
                this.createStatement(entity.getClass(), nodeName),
                getMapValue(entity)
        );
    }

    public <T extends GraphDbEntity> String createStatement(Class<T> clazz, String nodeName) {
        String fieldAssignment = getSerializableFields(clazz).stream().map(f -> f.getName() + ": $"+ f.getName()).collect(Collectors.joining(","));
        return "CREATE (" +
                nodeName +
                ":" +
                Neo4jLabelProvider.getInstance().getNodeLabel(clazz) +
                " {" +
                fieldAssignment +
                "}) RETURN " +
                nodeName;
    }

    public <T extends GraphDbEntity> Query updateQuery(T entity, String nodeName) {
        return new Query(
                this.updateStatement(entity.getClass(), nodeName),
                getMapValue(entity)
        );
    }

    public <T extends GraphDbEntity> String updateStatement(Class<T> clazz, String nodeName) {
        String fieldAssignment = getSerializableFields(clazz).stream().map(f -> f.getName() + ": $"+ f.getName()).collect(Collectors.joining(","));
        return "MATCH (" + nodeName + ":" + Neo4jLabelProvider.getInstance().getNodeLabel(clazz) +
                ")" +
                " WHERE id("+ nodeName +") = $id " +
                "SET " + nodeName + " = {" +
                fieldAssignment +
                "} RETURN " + nodeName;
    }

    protected <T extends GraphDbEntity> List<Field> getSerializableFields(Class<T> clazz) {
        if (serializableFieldsMap.containsKey(clazz)) {
            return serializableFieldsMap.get(clazz);
        }

        Set<Field> fields = ReflectionUtils.getAllFields(clazz);

        List<Field> serializableFields = new ArrayList<>();

        for (Field f : fields) {
            if (f.getAnnotation(Transient.class) == null && f.getAnnotation(NodeId.class) == null && f.getAnnotation(RelationField.class) == null) {
                serializableFields.add(f);
            }
        }

        serializableFieldsMap.put(clazz, serializableFields);
        return serializableFields;
    }


    private <T extends GraphDbEntity> Value getMapValue(T entity) {
        try {
            Map<String, Value> map = new HashMap<>();

            for (Field field : this.getSerializableFields(entity.getClass())) {
                field.setAccessible(true);
                map.put(field.getName(), value(field.get(entity)));
            }

            if (entity.getId() != null) {
                map.put("id", value(entity.getId()));
            }

            return value(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Query createRelationship(GraphDbEntity source, GraphDbEntity destination, Class<? extends GraphDbRelation> relationType) {
        return new Query(createRelationshipStatement(source, destination, relationType));
    }

    public String createRelationshipStatement(GraphDbEntity source, GraphDbEntity destination, Class<? extends GraphDbRelation> relationType) {
        String sourceLabel = Neo4jLabelProvider.getInstance().getNodeLabel(source.getClass());
        String destinationLabel = Neo4jLabelProvider.getInstance().getNodeLabel(destination.getClass());
        String relationLabel = Neo4jLabelProvider.getInstance().getRelationLabel(relationType);

        return "MATCH (s: " + sourceLabel + "), (d: " + destinationLabel + ") " +
                "WHERE s.uuid = '" + source.getUuid() + "' AND d.uuid = '" + destination.getUuid() + "' " +
                "CREATE (s)-[r:" + relationLabel + "]->(d) RETURN r";
    }

    public <S extends GraphDbEntity, D extends GraphDbEntity> Query createGetSource(D destination, Class<? extends GraphDbRelation> relationType, Class<S> sourceClass, String nodeName) {
        return new Query(createGetSourceStatement(destination, relationType, sourceClass, nodeName));
    }

    public <S extends GraphDbEntity, D extends GraphDbEntity> String createGetSourceStatement(D destination, Class<? extends GraphDbRelation> relationType, Class<S> sourceClass, String nodeName) {
        String sourceLabel = Neo4jLabelProvider.getInstance().getNodeLabel(sourceClass);
        String destinationLabel = Neo4jLabelProvider.getInstance().getNodeLabel(destination.getClass());
        String relationLabel = Neo4jLabelProvider.getInstance().getRelationLabel(relationType);

        return "MATCH (d: " + destinationLabel + " {uuid: '" + destination.getUuid() + "'}) " +
                "-[r: " + relationLabel + "]-> " +
                "(" + nodeName + ": " + sourceLabel + ") RETURN "+ nodeName;
    }
}
