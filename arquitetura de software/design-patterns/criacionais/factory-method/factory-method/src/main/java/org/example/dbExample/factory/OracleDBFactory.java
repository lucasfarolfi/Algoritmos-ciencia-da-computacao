package org.example.dbExample.factory;

import org.example.dbExample.db.DB;
import org.example.dbExample.db.OracleDB;

public class OracleDBFactory implements DBFactory{
    @Override
    public DB getDatabase(){
        return new OracleDB();
    }
}
