package com.durellinux.showcase.organizationservice;

import com.durellinux.showcase.commons.graphdb.decoder.NodeDecoder;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JQueryFactory;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JTransactionManager;
import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4jQueryRunner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class QueryRunner extends Neo4jQueryRunner {
    public static QueryRunner INSTANCE;

    private final Neo4JTransactionManager transactionManager;
    private final NodeDecoder nodeDecoder;

    @Inject
    public QueryRunner(Neo4JTransactionManager transactionManager, NodeDecoder nodeDecoder) {
        this.transactionManager = transactionManager;
        this.nodeDecoder = nodeDecoder;
        INSTANCE = this;
    }

    @Override
    protected Neo4JTransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    protected NodeDecoder getNodeDecoder() {
        return nodeDecoder;
    }
}
