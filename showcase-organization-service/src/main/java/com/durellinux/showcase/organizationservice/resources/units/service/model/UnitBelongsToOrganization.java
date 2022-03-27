package com.durellinux.showcase.organizationservice.resources.units.service.model;

import com.durellinux.showcase.commons.graphdb.GraphDbRelation;
import com.durellinux.showcase.commons.graphdb.annotations.Relation;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

@Relation(type = UnitBelongsToOrganization.RELATION_TYPE)
public class UnitBelongsToOrganization extends GraphDbRelation<Unit, Organization> {
    public static final String RELATION_TYPE = "BelongsTo";
}
