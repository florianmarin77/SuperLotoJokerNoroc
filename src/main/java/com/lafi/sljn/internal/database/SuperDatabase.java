package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.model.Sample;

import java.util.ArrayList;
import java.util.List;

public class SuperDatabase {

    // Singleton pattern
    private static SuperDatabase superDatabase = null;

    // database resource
    private List<Sample> superList = new ArrayList<>();

    // constructor
    private SuperDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized SuperDatabase getInstance() {
        if (superDatabase == null) {
            superDatabase = new SuperDatabase();
        }
        return superDatabase;
    }

    // getters & setters
    public List<Sample> getSuperList() {
        return superList;
    }

    public void setSuperList(List<Sample> superList) {
        this.superList = superList;
    }
}
