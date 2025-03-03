package org.example.simple.db;

public interface DB {
    void query(String sql);
    void update(String sql);
}
