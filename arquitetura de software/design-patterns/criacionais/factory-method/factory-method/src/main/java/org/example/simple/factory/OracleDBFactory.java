package org.example.simple.factory;

import org.example.simple.db.DB;
import org.example.simple.db.OracleDB;

public class OracleDBFactory implements DBFactory{
    @Override
    public DB getDatabase(){
        return new OracleDB();
    }
}
