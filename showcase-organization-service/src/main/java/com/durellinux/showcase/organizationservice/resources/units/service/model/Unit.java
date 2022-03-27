package com.durellinux.showcase.organizationservice.resources.units.service.model;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.annotations.Node;
import com.durellinux.showcase.commons.graphdb.annotations.RelationField;
import com.durellinux.showcase.organizationservice.QueryRunner;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JQueryFactory;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

@Node(label = "Unit")
public class Unit extends GraphDbEntity {

    @RelationField(relationType = UnitBelongsToOrganization.class)
    private Organization organization;

    private String name;

    public Unit() {
        // Empty constructor for serialization
    }

    public Unit(String name, Organization organization) {
        this.name = name;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public Organization getOrganization() {
        if (organization == null) {
            Neo4JQueryFactory queryFactory = new Neo4JQueryFactory();
            organization = QueryRunner.INSTANCE.runSingleValueQuery(
                    queryFactory.createGetSource(this, UnitBelongsToOrganization.class, Organization.class, "s"),
                    "s",
                    Organization.class
            );
        }
        return organization;
    }
}
