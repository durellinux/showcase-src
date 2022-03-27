package com.durellinux.showcase.organizationservice.commons.neo4j;

import io.quarkus.logging.Log;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Transaction;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Neo4JTransactionManager {
    private static final String mdcRequestKey = "NEO4J_TRANSACTION_ID";
    private final Map<UUID, RequestTransaction> transactionMap = new HashMap<>();

    protected abstract Driver getDriver();

    public Transaction openSessionTransaction() {
        Log.debug("Opening transaction");
        return createOrGetRequestTransaction().getTransaction();
    }

    public UUID getMdcRequestKey() {
        String key = MDC.get(mdcRequestKey);
        if (key != null) {
            return UUID.fromString(key);
        }

        UUID keyUuid = UUID.randomUUID();
        MDC.put(mdcRequestKey, keyUuid.toString());

        return keyUuid;
    }

    private RequestTransaction createOrGetRequestTransaction() {
        UUID requestKey = getMdcRequestKey();

        if (transactionMap.containsKey(requestKey)) {
            Log.debug("Attaching transaction");
            RequestTransaction transaction = transactionMap.get(requestKey);
            transaction.openTransaction();

            return transaction;
        }

        RequestTransaction transaction = new RequestTransaction(requestKey, getDriver());
        transactionMap.put(requestKey, transaction);

        Log.debug("New transaction");
        return transaction;
    }

    public void commitSessionTransaction() {
        Log.debug("Committing transaction");
        RequestTransaction requestTransaction = createOrGetRequestTransaction();
        requestTransaction.commitTransaction();

        if (requestTransaction.getAttached() == 0) {
            this.closeSessionTransaction();
        }
    }

    public void rollbackSessionTransaction() {
        Log.debug("Rolling back transaction");
        RequestTransaction requestTransaction = createOrGetRequestTransaction();
        requestTransaction.rollbackTransaction();

        if (requestTransaction.getAttached() == 0) {
            this.closeSessionTransaction();
        }
    }

    public void closeSessionTransaction() {
        Log.debug("Committing transaction");
        RequestTransaction requestTransaction = createOrGetRequestTransaction();
        requestTransaction.closeTransaction();
        requestTransaction.getSession().close();
        this.transactionMap.remove(requestTransaction.getKey());
    }
}
