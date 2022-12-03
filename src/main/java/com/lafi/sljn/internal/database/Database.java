package com.lafi.sljn.internal.database;

import com.lafi.sljn.internal.loader.ResourceLoader;

public class Database {
    static final ResourceLoader LOADER = new ResourceLoader();

    static final SuperDatabase SUPERDB = SuperDatabase.getInstance();
    static final LotoDatabase LOTODB = LotoDatabase.getInstance();
    static final JokerDatabase JOKERDB = JokerDatabase.getInstance();
}
