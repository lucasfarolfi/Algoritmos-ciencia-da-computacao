package org.example.dbExample;

import org.example.dbExample.db.DB;
import org.example.dbExample.factory.PostgresDBFactory;

public class Client {
    public static void main(String[] args) {
        DB db = new PostgresDBFactory().getDatabase();
        //DB db = new OracleDBFactory().getDatabase();

        db.query("SELECT * FROM users");
        db.query("INSERT INTO users VALUES ('User', 25)");
    }
}