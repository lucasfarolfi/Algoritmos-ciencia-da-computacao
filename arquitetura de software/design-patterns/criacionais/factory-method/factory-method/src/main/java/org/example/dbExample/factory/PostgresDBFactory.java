package org.example.dbExample.factory;

import org.example.dbExample.db.DB;
import org.example.dbExample.db.PostgresDB;

public class PostgresDBFactory implements DBFactory{
    @Override
    public DB getDatabase(){
        return new PostgresDB();
    }
}
