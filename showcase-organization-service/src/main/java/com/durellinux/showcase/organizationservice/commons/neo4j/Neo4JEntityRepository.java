package com.durellinux.showcase.organizationservice.commons.neo4j;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.GraphDbRelation;
import com.durellinux.showcase.commons.graphdb.annotations.Node;
import com.durellinux.showcase.commons.graphdb.annotations.RelationField;
import org.neo4j.driver.*;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Neo4JEntityRepository<T extends GraphDbEntity> {
    protected abstract Neo4JQueryFactory getQueryFactory();
    protected abstract Class<T> getClazz();
    protected abstract Neo4jQueryRunner getQueryRunner();

    protected Map<Class, List<Field>> relationfieldsMap;

    public Neo4JEntityRepository() {
        this.relationfieldsMap = new HashMap<>();
    }

    private String getLabel() {
        return Neo4jLabelProvider.getInstance().getNodeLabel(getClazz());
    }

    private String getQueryNodeName() {
        return getLabel().substring(0, 1);
    }

    public T save(T entity) {
        if(entity.getId() == null) {
            return this.create(entity);
        } else {
            return this.update(entity);
        }
    }

    private T create(T entity) {
        Query query = getQueryFactory().createQuery(entity, getQueryNodeName());
        T result = getQueryRunner().runSingleValueQuery(query, getQueryNodeName(), getClazz());

        List<Field> relationFields = getRelationFields(entity.getClass());
        for(Field field: relationFields) {
            createRelation(entity, field);
        }

        return result;
    }

    private void createRelation(T entity, Field relationField) {
        try {
            relationField.setAccessible(true);
            GraphDbEntity otherEntity = (GraphDbEntity) relationField.get(entity); // TODO: Add check
            RelationField relationFieldAnnotation = relationField.getAnnotation(RelationField.class);
            Class<? extends GraphDbRelation> relation = relationFieldAnnotation.relationType();
            Query relationCreationQuery = getQueryFactory().createRelationship(entity, otherEntity, relation);
            getQueryRunner().runQueryNoResult(relationCreationQuery);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private T update(T entity) {
        Query query = getQueryFactory().updateQuery(entity, getQueryNodeName());
        return getQueryRunner().runSingleValueQuery(query, getQueryNodeName(), getClazz());
    }

    public Optional<T> findById(Long id) {
        String statement = new StringBuilder()
                .append("MATCH (n:").append(getLabel())
                .append(")")
                .append(" WHERE id(n) = $id ")
                .append(" RETURN n")
                .toString();
        Query query = new Query(statement);

        return getQueryRunner().runOptionalSingleValueQuery(query, "n", getClazz());
    }

    public Optional<T> findByUuid(UUID uuid) {
        String statement = new StringBuilder()
                .append("MATCH (n:").append(getLabel())
                .append(" {uuid: $uuid})")
                .append(" RETURN n")
                .toString();
        Query query = new Query(statement, Values.parameters("uuid", uuid.toString()));

        return getQueryRunner().runOptionalSingleValueQuery(query, "n", getClazz());
    }

    public Optional<T> findOneBy(Object... keysAndValues) {
        List<String> filterKeys = new ArrayList<>();

        for(int i = 0; i < keysAndValues.length; i += 2) {
            String value = keysAndValues[i].toString();
            filterKeys.add(value);
        }

        String filterQuery = filterKeys.stream().map(f -> f + ": $"+ f).collect(Collectors.joining(","));
        String statement = new StringBuilder()
                .append("MATCH (n:").append(getLabel())
                .append(" {")
                .append(filterQuery)
                .append("}) RETURN n")
                .toString();
        Query query = new Query(statement, Values.parameters(keysAndValues));

        return getQueryRunner().runOptionalSingleValueQuery(query, "n", getClazz());
    }

    public void delete(T entity) {
        String statement = new StringBuilder()
                .append("MATCH (n:").append(getLabel())
                .append(")")
                .append(" WHERE id(n) = $id ")
                .append(" DETACH DELETE n")
                .toString();
        Query query = new Query(statement, Values.parameters("id", entity.getId()));

        getQueryRunner().runQueryNoResult(query);
    }

    protected <T extends GraphDbEntity> List<Field> getRelationFields(Class<T> clazz) {
        if (relationfieldsMap.containsKey(clazz)) {
            return relationfieldsMap.get(clazz);
        }

        Set<Field> fields = ReflectionUtils.getAllFields(clazz);

        List<Field> relationFields = new ArrayList<>();

        for (Field f : fields) {
            if (f.getAnnotation(RelationField.class) != null) {
                relationFields.add(f);
            }
        }

        relationfieldsMap.put(clazz, relationFields);
        return relationFields;
    }

}
