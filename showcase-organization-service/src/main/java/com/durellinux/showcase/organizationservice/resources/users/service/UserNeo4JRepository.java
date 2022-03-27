package com.durellinux.showcase.organizationservice.resources.users.service;

import com.durellinux.showcase.commons.graphdb.decoder.NodeDecoder;
import com.durellinux.showcase.organizationservice.QueryRunner;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JEntityRepository;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JQueryFactory;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4jQueryRunner;
import com.durellinux.showcase.organizationservice.resources.users.service.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserNeo4JRepository extends Neo4JEntityRepository<User> {
    private final Neo4JQueryFactory neo4JQueryFactory;
    private final QueryRunner queryRunner;

    @Inject
    public UserNeo4JRepository(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
        this.neo4JQueryFactory = new Neo4JQueryFactory();
    }

    @Override
    protected Neo4JQueryFactory getQueryFactory() {
        return neo4JQueryFactory;
    }

    @Override
    protected Class<User> getClazz() {
        return User.class;
    }

    @Override
    protected Neo4jQueryRunner getQueryRunner() {
        return queryRunner;
    }
}
