package org.example.simple.db;

public class OracleDB implements DB {

    @Override
    public void query(String sql) {
        System.out.printf("Querying %s in Oracle DB", sql);
    }

    @Override
    public void update(String sql) {
        System.out.printf("Updating %s in Oracle DB", sql);
    }
}
