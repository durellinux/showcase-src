package com.durellinux.showcase.commons.graphdb.annotations;

import com.durellinux.showcase.commons.graphdb.GraphDbRelation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RelationField {
    Class<? extends GraphDbRelation> relationType();
}
