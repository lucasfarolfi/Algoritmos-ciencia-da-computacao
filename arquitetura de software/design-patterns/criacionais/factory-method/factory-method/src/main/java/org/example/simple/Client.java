package org.example.simple;

import org.example.iphoneExample.shared.IPhone;
import org.example.simple.db.DB;
import org.example.simple.factory.DBFactory;
import org.example.simple.factory.OracleDBFactory;
import org.example.simple.factory.PostgresDBFactory;

public class Client {
    public static void main(String[] args) {
        DB db = new PostgresDBFactory().getDatabase();
        //DB db = new OracleDBFactory().getDatabase();

        db.query("SELECT * FROM users");
        db.query("INSERT INTO users VALUES ('User', 25)");
    }
}