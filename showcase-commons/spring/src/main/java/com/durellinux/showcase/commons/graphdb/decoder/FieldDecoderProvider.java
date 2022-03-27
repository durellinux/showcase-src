package com.durellinux.showcase.commons.graphdb.decoder;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FieldDecoderProvider {
    private Map<Class<?>, IFieldDecoder<?>> fieldDecoders;

    public FieldDecoderProvider() {
        try {
            this.fieldDecoders = new HashMap<>();

            Reflections reflections = new Reflections("com.durellinux.showcase.commons.graphdb.decoder");
            Set<Class<? extends IFieldDecoder>> fieldDecoderClasses = reflections.getSubTypesOf(IFieldDecoder.class);

            for (Class<? extends IFieldDecoder> clazz : fieldDecoderClasses) {
                Constructor<? extends IFieldDecoder> emptyConstructor = clazz.getDeclaredConstructor();
                IFieldDecoder<?> fieldDecoder = emptyConstructor.newInstance();
                this.registerDecoder(fieldDecoder);
            }
        } catch (Exception e) {
            // TODO: Throw better exception
            throw new RuntimeException(e);
        }
    }

    private void registerDecoder(IFieldDecoder<?> fieldDecoder) throws Exception {
        for (Class<?> decodedType: fieldDecoder.getDecodedTypes()) {
            if (this.fieldDecoders.containsKey(decodedType)) {
                throw new Exception("Field decoder already registered: " + decodedType.getName());
            }

            this.fieldDecoders.put(decodedType, fieldDecoder);
        }
    }

    public IFieldDecoder getDecoderForField(Field field) {
        Class clazz = field.getType();

        if (this.fieldDecoders.containsKey(clazz)) {
            return this.fieldDecoders.get(clazz);
        }

        throw new RuntimeException("Field decoder not registered for type: " + clazz.getName());
    }
}
