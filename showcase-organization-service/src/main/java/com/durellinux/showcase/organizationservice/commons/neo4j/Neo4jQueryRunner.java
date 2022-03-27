package com.durellinux.showcase.organizationservice.commons.neo4j;

import com.durellinux.showcase.commons.graphdb.GraphDbEntity;
import com.durellinux.showcase.commons.graphdb.decoder.NodeDecoder;
import org.neo4j.driver.Query;
import org.neo4j.driver.Result;
import org.neo4j.driver.Transaction;

import java.util.Optional;

public abstract class Neo4jQueryRunner {
    protected abstract Neo4JTransactionManager getTransactionManager();
    protected abstract NodeDecoder getNodeDecoder();

    public <T extends GraphDbEntity> T runSingleValueQuery(Query query, String key, Class<T> clazz) {
        return runOptionalSingleValueQuery(query, key, clazz)
                .orElseThrow(() -> new RuntimeException("Node not found"));
    }

    public <T extends GraphDbEntity> Optional<T> runOptionalSingleValueQuery(Query query, String key, Class<T> clazz) {
        Transaction transaction = getTransactionManager().openSessionTransaction();
        Result result = transaction.run(query);

        Optional<T> resultNode = getNodeDecoder().fromResult(result, key, clazz);
        getTransactionManager().commitSessionTransaction();

        return resultNode;
    }

    public void runQueryNoResult(Query query) {
        Transaction transaction = getTransactionManager().openSessionTransaction();
        transaction.run(query);
        getTransactionManager().commitSessionTransaction();
    }
}
