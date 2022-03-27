package com.durellinux.showcase.organizationservice;

import com.durellinux.showcase.organizationservice.commons.neo4j.Neo4JTransactionManager;
import org.neo4j.driver.Driver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TransactionManager extends Neo4JTransactionManager {

    private final Driver driver;

    @Inject
    public TransactionManager(Driver driver) {
        this.driver = driver;
    }

    @Override
    protected Driver getDriver() {
        return driver;
    }
}
