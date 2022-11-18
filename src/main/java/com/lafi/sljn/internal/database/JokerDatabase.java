package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.model.Sample;

import java.util.ArrayList;
import java.util.List;

public class JokerDatabase {

    // Singleton pattern
    private static JokerDatabase jokerDatabase = null;

    // database resource
    private List<Sample> jokerList = new ArrayList<>();

    // constructor
    private JokerDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized JokerDatabase getInstance() {
        if (jokerDatabase == null) {
            jokerDatabase = new JokerDatabase();
        }
        return jokerDatabase;
    }

    // getters & setters
    public List<Sample> getJokerList() {
        return jokerList;
    }

    public void setJokerList(List<Sample> jokerList) {
        this.jokerList = jokerList;
    }
}
