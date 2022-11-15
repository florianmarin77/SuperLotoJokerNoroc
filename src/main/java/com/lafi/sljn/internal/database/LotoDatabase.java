package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.model.Sample;

import java.util.ArrayList;
import java.util.List;

public class LotoDatabase implements Database {

    // Singleton pattern
    private static LotoDatabase lotoDatabase = null;

    // database resource
    private List<Sample> lotoList = new ArrayList<>();

    // constructor
    private LotoDatabase() {
        // prevent instantiation
    }

    // Thread Safe Lazy Singleton
    public static synchronized LotoDatabase getInstance() {
        if (lotoDatabase == null) {
            lotoDatabase = new LotoDatabase();
        }
        return lotoDatabase;
    }

    // getters & setters
    public List<Sample> getLotoList() {
        return lotoList;
    }

    public void setLotoList(List<Sample> lotoList) {
        this.lotoList = lotoList;
    }
}
