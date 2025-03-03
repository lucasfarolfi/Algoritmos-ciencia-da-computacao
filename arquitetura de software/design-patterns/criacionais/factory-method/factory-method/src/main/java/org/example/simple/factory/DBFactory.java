package org.example.simple.factory;

import org.example.iphoneExample.shared.*;
import org.example.simple.db.DB;

public interface DBFactory {
    DB getDatabase();
}
