package com.durellinux.showcase.commons.graphdb.decoder;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.annotations.NodeId;
import com.durellinux.showcase.commons.graphdb.annotations.RelationField;
import org.neo4j.driver.Result;
import org.neo4j.driver.types.Node;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;

public class NodeDecoder {

    private final FieldDecoderProvider fieldDecoderProvider = new FieldDecoderProvider();

    public NodeDecoder() { }

    public <T extends GraphDbEntity> Optional<T> fromResult(Result result, String key, Class<T> clazz) {
        if (result.hasNext()) {
            T entity = fromNode(result.single().get(key).asNode(), clazz);
            return Optional.of(entity);
        }

        return Optional.empty();
    }

    public <T extends GraphDbEntity> T fromNode(Node node, Class<T> clazz) {
        try {
            Set<Field> fields = ReflectionUtils.getAllFields(clazz);

            Constructor<T> emptyConstructor = clazz.getConstructor();
            T instance = emptyConstructor.newInstance();

            for (Field f : fields) {
                if (f.getAnnotation(RelationField.class) == null) {
                    if (f.getAnnotation(NodeId.class) != null) {
                        f.setAccessible(true);
                        f.set(instance, node.id());
                    } else {
                        IFieldDecoder fieldDecoder = fieldDecoderProvider.getDecoderForField(f);
                        f.setAccessible(true);
                        f.set(instance, fieldDecoder.decode(f.getName(), node));
                    }

                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}