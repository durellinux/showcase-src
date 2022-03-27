package com.durellinux.showcase.organizationservice.resources.units.service;

import com.durellinux.showcase.organizationservice.QueryRunner;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JEntityRepository;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JQueryFactory;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4jQueryRunner;
import com.durellinux.showcase.organizationservice.resources.units.service.model.Unit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UnitNeo4JRepository extends Neo4JEntityRepository<Unit> {
    private final Neo4JQueryFactory neo4JQueryFactory;
    private final QueryRunner queryRunner;

    @Inject
    public UnitNeo4JRepository(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
        this.neo4JQueryFactory = new Neo4JQueryFactory();
    }

    @Override
    protected Neo4JQueryFactory getQueryFactory() {
        return neo4JQueryFactory;
    }

    @Override
    protected Class<Unit> getClazz() {
        return Unit.class;
    }

    @Override
    protected Neo4jQueryRunner getQueryRunner() {
        return queryRunner;
    }
}
