package org.example.simple.factory;

import org.example.simple.db.DB;
import org.example.simple.db.OracleDB;
import org.example.simple.db.PostgresDB;

public class PostgresDBFactory implements DBFactory{
    @Override
    public DB getDatabase(){
        return new PostgresDB();
    }
}
