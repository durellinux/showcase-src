package com.durellinux.showcase.organizationservice.resources.organizations.service;

import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JEntityRepository;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JQueryFactory;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4jQueryRunner;
import com.durellinux.showcase.organizationservice.QueryRunner;
import com.durellinux.showcase.organizationservice.resources.organizations.service.model.Organization;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OrganizationNeo4JRepository extends Neo4JEntityRepository<Organization> {
    private final Neo4JQueryFactory neo4JQueryFactory;
    private final QueryRunner queryRunner;

    @Override
    protected Neo4JQueryFactory getQueryFactory() {
        return neo4JQueryFactory;
    }

    @Inject
    public OrganizationNeo4JRepository(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
        this.neo4JQueryFactory = new Neo4JQueryFactory();
    }

    @Override
    protected Class<Organization> getClazz() {
        return Organization.class;
    }

    @Override
    protected Neo4jQueryRunner getQueryRunner() {
        return queryRunner;
    }

}
