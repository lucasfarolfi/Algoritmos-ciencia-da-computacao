package org.example.dbExample.db;

public class PostgresDB implements DB {

    @Override
    public void query(String sql) {
        System.out.printf("Querying %s in Postgres DB", sql);
    }

    @Override
    public void update(String sql) {
        System.out.printf("Updating %s in Postgres DB", sql);
    }
}
