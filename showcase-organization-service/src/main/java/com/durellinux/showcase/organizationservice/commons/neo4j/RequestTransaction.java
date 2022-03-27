package com.durellinux.showcase.organizationservice.commons.neo4j;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import io.quarkus.logging.Log;

import java.util.UUID;

public class RequestTransaction {

    private final UUID key;
    private Session session;
    private Transaction transaction;
    private long attached;
    public boolean markedForRollback;

    public RequestTransaction(UUID key, Driver driver) {
        this.key = key;
        session = driver.session();
        transaction = session.beginTransaction();
        attached = 1;
        markedForRollback = false;
    }

    public UUID getKey() {
        return key;
    }

    public Session getSession() {
        return this.session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void commitTransaction() {
        this.attached--;
        if (attached == 0) {
            closeTransaction();
        }
    }

    public void rollbackTransaction() {
        this.attached--;
        this.markedForRollback = true;
        if (attached == 0) {
            closeTransaction();
        }
    }

    public void openTransaction() {
        this.attached++;
        Log.debug("Attaching to transaction: " + key + " ("+this.attached+" processes)");
    }

    public void closeTransaction() {
        Log.debug("Closing transaction: " + key + " ("+this.attached+" processes)");
        if (markedForRollback) {
            Log.error("Roll back");
            transaction.rollback();
        } else {
            Log.error("Commit");
            transaction.commit();
        }
    }

    public long getAttached() {
        return attached;
    }
}
